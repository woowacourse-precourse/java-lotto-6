package lotto.controller.controllers;

import lotto.dto.InputDto;
import lotto.dto.OutputDto;

import java.util.Map;

public interface Controller {
    void process(Map<String, InputDto> inputs, Map<String, OutputDto> outputs);
}
