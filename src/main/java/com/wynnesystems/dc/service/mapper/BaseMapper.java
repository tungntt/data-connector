package com.wynnesystems.dc.service.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    E toEntity(final D dto);

    D toDTO (final E entity);

    List<E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
