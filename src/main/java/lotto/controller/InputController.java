package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.service.InputService;

public class InputController {

    private final InputService inputService = new InputService();

    public Integer getNumber(){
        return inputService.getNumber();
    }

    public List<Integer> getNumbers(){
        return inputService.getNumbers();
    }
}
