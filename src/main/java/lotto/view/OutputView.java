package lotto.view;

import lotto.dto.Dto;

import java.util.Map;

public interface OutputView {
    void view(Map<String, ? super Dto.Output> model);
}
