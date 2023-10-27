package com.tenpo.apirest.application.service;

import com.tenpo.apirest.infrastructure.mapper.SortType;
import org.springframework.data.domain.Page;

public interface AbstractService<R,ID> {
    Page<R> readAll(Integer page, Integer size, SortType sortType);
    R created(R request);
    R read(ID id);
    R update(R request, ID id);
    void delete(ID id);

    String FIELD_BY_SHORT = "ANY";
}
