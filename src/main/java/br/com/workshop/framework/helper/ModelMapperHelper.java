package br.com.workshop.framework.helper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperHelper {

    @Autowired
    private ModelMapper mapper;

    public <T> T map(Object model, Class<T> dtoClass) {
        return mapper.map(model,dtoClass);
    }

    public <D, T> List<D> mapToList(List<T> list, Class<D> dto) {
        return list.stream()
                .map(element -> mapper.map(element,dto))
                .collect(Collectors.toList());
    }


}
