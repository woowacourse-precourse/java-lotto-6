package lotto.view;

import lotto.dto.InputDto;

import java.util.Map;

public interface InputView {
    void read(Map<String, InputDto> inputs);
}
