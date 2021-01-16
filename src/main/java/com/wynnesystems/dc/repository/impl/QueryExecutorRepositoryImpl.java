package com.wynnesystems.dc.repository.impl;

import com.wynnesystems.dc.repository.QueryExecutorRepository;
import com.wynnesystems.dc.service.dto.QueryExecutorDTO;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.internal.NativeQueryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

import static org.hibernate.transform.Transformers.ALIAS_TO_ENTITY_MAP;

@Repository
@Slf4j
public class QueryExecutorRepositoryImpl extends BaseQueryRepository
        implements QueryExecutorRepository {

    private static final String SEL_ALL_QUERY = "SELECT * FROM %s";
    private static final String SEL_ALL_LIMIT_QUERY = "SELECT * FROM %s LIMIT %s";

    @Override
    public List<Map<String, Object>> getAll(final QueryExecutorDTO dto, final int limit) {
        String sql;
        if (limit > 0) {
            sql = String.format(SEL_ALL_LIMIT_QUERY, dto.getMasterData().getQueriedTable(), limit);
        } else {
            sql = String.format(SEL_ALL_QUERY, dto.getMasterData().getQueriedTable());
        }
        final EntityManager entityManager = this.getEntityManager(dto.getConnector());
        return this.query(entityManager, sql);
    }

    private List<Map<String, Object>> query (final EntityManager entityManager, final String sql) {
        entityManager.getTransaction().begin();
        final List list = entityManager.createNativeQuery(sql).unwrap(NativeQueryImpl.class)
                .setResultTransformer(ALIAS_TO_ENTITY_MAP).list();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

}
