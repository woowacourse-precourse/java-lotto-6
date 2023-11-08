package lotto.controller.controllers;

import lotto.dto.Dto;

import java.util.Map;

public interface Controller {
    void process(Map<String, ? super Dto.Input> inputs, Map<String, ? super Dto.Output> outputs);
}
