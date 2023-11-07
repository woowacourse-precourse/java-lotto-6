package lotto.controller;

import lotto.dto.DTO;

import java.util.Map;

public interface Controller {
    void process(Map<String, ? super DTO.Input> inputDto, Map<String, ? super DTO.Output> outputDto);
}
