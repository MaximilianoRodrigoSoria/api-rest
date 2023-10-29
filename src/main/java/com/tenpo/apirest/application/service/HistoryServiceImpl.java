package com.tenpo.apirest.application.service;

import com.tenpo.apirest.application.repository.HistoryRepository;
import com.tenpo.apirest.domain.History;
import com.tenpo.apirest.infrastructure.mapper.HistoryMapper;
import com.tenpo.apirest.infrastructure.mapper.SortType;
import com.tenpo.apirest.infrastructure.util.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository repository;
    private HistoryMapper mapper;
    @Override
    public Page<History> readAll(Integer page, Integer size, SortType sortType) {
        PageRequest pageRequest = null;
        switch (sortType){
            case NONE -> pageRequest = PageRequest.of(page,size);
            case LOWER -> pageRequest= PageRequest.of(page,size, Sort.by(FIELD_BY_SHORT).ascending());
            case UPPER -> pageRequest = PageRequest.of(page,size,Sort.by(FIELD_BY_SHORT).descending());
        }
        return repository.findAll(pageRequest).map(mapper::toModel);
    }

    @Override
    public History created(History request) {
        return mapper.toModel(repository.save(mapper.toEntity(request)));
    }

    @Override
    public History read(Integer id) {
        var reservertionBD = repository.findById(id).orElseThrow(()-> new IdNotFoundException("History"));
        return mapper.toModel(reservertionBD);
    }

    @Override
    public History update(History request, Integer id) {
        var history = repository.findById(id);
        if (history.isEmpty()){
            throw new IdNotFoundException("History");
        }
        request.setId(history.get().getId());
        repository.save(mapper.toEntity(request));
        return request;
    }

    @Override
    public void delete(Integer id) {
        var reservation= repository.findById(id).orElseThrow(()-> new IdNotFoundException("History"));
        repository.delete(reservation);
    }
}
