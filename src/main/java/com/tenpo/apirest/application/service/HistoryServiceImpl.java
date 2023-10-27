package com.tenpo.apirest.application.service;

import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.mapper.SortType;
import org.springframework.data.domain.Page;

public class HistoryServiceImpl implements HistoryService {


    @Override
    public Page<History> readAll(Integer page, Integer size, SortType sortType) {
        return null;
    }

    @Override
    public History created(History request) {
        return null;
    }

    @Override
    public History read(Integer integer) {
        return null;
    }

    @Override
    public History update(History request, Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
