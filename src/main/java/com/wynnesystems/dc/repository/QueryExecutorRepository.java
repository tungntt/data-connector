package com.wynnesystems.dc.repository;

import com.wynnesystems.dc.service.dto.QueryExecutorDTO;

import java.util.List;
import java.util.Map;

public interface QueryExecutorRepository {

    List<Map<String, Object>> getAll(final QueryExecutorDTO dto, final int limit);
}
