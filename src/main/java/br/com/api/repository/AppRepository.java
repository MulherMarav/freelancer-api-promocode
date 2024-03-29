package br.com.api.repository;

import br.com.api.model.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppRepository extends JpaRepository<App, UUID> {

    Optional<App> findByUidAndToken(String uidApp, String token);

}
