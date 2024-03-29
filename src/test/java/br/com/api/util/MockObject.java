package br.com.api.util;

import br.com.api.dto.ClienteDTO;
import br.com.api.dto.EventoManualDTO;
import br.com.api.model.*;

import static br.com.api.model.TipoEventoManual.ADD;
import static br.com.api.model.TipoEventoManual.RET;
import static br.com.api.util.DateFormatter.dateFormatter;

public class MockObject {

    public static final int SERVER_PORT = 8888;
    public static final String HEADER_PARAM_AUTHORIZATION = "token";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static String PROMO_CODE = "AQDC3BO";
    public static String TOKEN = "q4YZ$ys5etJMrmnV";

    public static ClienteDTO clienteAfiliadoDTO() {
        return ClienteDTO.builder()
                .nome(clienteAfiliado().getNome())
                .email(clienteAfiliado().getEmail())
                .build();
    }

    public static ClienteDTO clienteAfiliadoDTO2() {
        return ClienteDTO.builder()
                .nome(clienteAfiliado2().getNome())
                .email(clienteAfiliado2().getEmail())
                .build();
    }

    public static ClienteDTO clientePadrinhoDTO() {
        return ClienteDTO.builder()
                .nome(clientePadrinho().getNome())
                .email(clientePadrinho().getEmail())
                .build();
    }

    public static PromoCodeID promoCodeID() {
        return PromoCodeID.builder()
                .produto(produto())
                .clientePadrinho(clientePadrinho())
                .build();
    }

    public static PromoCode promoCode() {
        return PromoCode.builder()
                .promoCodeId(promoCodeID())
                .promoCode("AQDC3BO")
                .limiteAplicacoesAfiliados(
                        promoCodeID().getProduto()
                                .getLimiteAplicacoesAfiliados())
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static ProdutoID produtoID() {
        return ProdutoID.builder()
                .id("ff0c-4581-97c7")
                .app(app())
                .build();
    }

    public static Produto produto() {
        return Produto.builder()
                .produtoId(produtoID())
                .nome("Black Friday")
                .limiteAplicacoesAfiliados(1)
                .limiteAplicacaoBonusPadrinho(3)
                .moedaPadrinho(2)
                .moedaAfiliado(20)
                .postWebhockPadrinho("Promoção")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static App app() {
        return App.builder()
                .uid("26ed47e2-281eeab5e652")
                .nome("Tua Agenda")
                .token("q4YZ$ys5etJMrmnV")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static ClienteID clientePadrinhoID() {
        return ClienteID.builder()
                .id("4581-97c7")
                .app(app())
                .build();
    }

    public static Cliente clientePadrinho() {
        return Cliente.builder()
                .clienteId(clientePadrinhoID())
                .nome("Maria")
                .email("maria@gmail.com")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static ClienteID clienteAfiliadoID() {
        return ClienteID.builder()
                .id("ff0c-4581")
                .app(app())
                .build();
    }

    public static ClienteID clienteAfiliadoID2() {
        return ClienteID.builder()
                .id("ff1c-5842")
                .app(app())
                .build();
    }

    public static Cliente clienteAfiliado() {
        return Cliente.builder()
                .clienteId(clienteAfiliadoID())
                .nome("Joana")
                .email("joana@gmail.com")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static Cliente clienteAfiliado2() {
        return Cliente.builder()
                .clienteId(clienteAfiliadoID2())
                .nome("Matheus")
                .email("Matheus@gmail.com")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static EventoAfiliadoID eventoAfiliadoID() {
        return EventoAfiliadoID.builder()
                .promoCode(promoCode())
                .clienteAfiliado(clienteAfiliado())
                .build();
    }

    public static EventoAfiliado eventoAfiliado() {
        return EventoAfiliado.builder()
                .eventoAfiliadoId(eventoAfiliadoID())
                .moeda(eventoAfiliadoID().getPromoCode().getPromoCodeId()
                        .getProduto().getMoedaAfiliado())
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static EventoPadrinhoID eventoPadrinhoID() {
        return EventoPadrinhoID.builder()
                .uid("4299-ab0c")
                .eventoAfiliado(eventoAfiliado())
                .build();
    }

    public static EventoPadrinho eventoPadrinho() {
        return EventoPadrinho.builder()
                .eventoPadrinhoId(eventoPadrinhoID())
                .moeda(eventoPadrinhoID().getEventoAfiliado().getEventoAfiliadoId()
                        .getPromoCode().getPromoCodeId().getProduto().getMoedaPadrinho())
                .idReferencia("485-333")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static EventoManualID eventoManualIDADD() {
        return EventoManualID.builder()
                .uid("418e-8c65")
                .cliente(clientePadrinho())
                .build();
    }

    public static EventoManual eventoManualADD() {
        return EventoManual.builder()
                .eventoManualId(eventoManualIDADD())
                .moeda(10)
                .motivo("Adiciona saldo para assinatura")
                .tipo(ADD)
                .idReferencia("8c65")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static EventoManualDTO eventoManualDTOADD() {
        return EventoManualDTO.builder()
                .motivo(eventoManualADD().getMotivo())
                .tipo(eventoManualADD().getTipo())
                .moeda(eventoManualADD().getMoeda())
                .idReferencia(eventoManualADD().getIdReferencia())
                .build();
    }

    public static EventoManualID eventoManualIDRET() {
        return EventoManualID.builder()
                .uid("4147e-85261")
                .cliente(clienteAfiliado())
                .build();
    }

    public static EventoManual eventoManualRET() {
        return EventoManual.builder()
                .eventoManualId(eventoManualIDRET())
                .moeda(-45)
                .motivo("Adiciona saldo para assinatura")
                .tipo(RET)
                .idReferencia("8485")
                .dtCriacao(dateFormatter("2022-11-21"))
                .build();
    }

    public static EventoManualDTO eventoManualDTORET() {
        return EventoManualDTO.builder()
                .motivo(eventoManualRET().getMotivo())
                .tipo(eventoManualRET().getTipo())
                .moeda(eventoManualRET().getMoeda())
                .idReferencia(eventoManualRET().getIdReferencia())
                .build();
    }

}
