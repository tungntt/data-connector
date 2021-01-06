package com.wynnesystems.dc.repository;

import com.wynnesystems.dc.domain.ConnectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectorRepository extends JpaRepository<ConnectorEntity, Long> {
}
