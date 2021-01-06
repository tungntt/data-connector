package com.wynnesystems.dc.repository;

import com.wynnesystems.dc.domain.MasterDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterDataRepository extends JpaRepository<MasterDataEntity, Long> {
}
