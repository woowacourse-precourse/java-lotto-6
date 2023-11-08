package lotto.view;

import lotto.dto.Dto;

import java.util.Map;

public interface InputView {
    void read(Map<String, ? super Dto.Input> parameter);
}
