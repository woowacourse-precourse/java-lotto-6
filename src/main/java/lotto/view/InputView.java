package lotto.view;

import lotto.dto.DTO;

import java.util.Map;

public interface InputView {
    void read(Map<String, ? extends DTO.Input> parameter);
}
