package org.example.dto.assembler;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericDtoAssembler<S,T> {

    T convertToDto(S modelObj);

    S convertFromDto(T modelObj);

    default List<T> convertToDto(List<S> listToConvert) {
        return listToConvert.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    default List<S> convertFromDto(List<T> listToConvert) {
        return listToConvert.stream()
                .map(this::convertFromDto)
                .collect(Collectors.toList());
    }
}
