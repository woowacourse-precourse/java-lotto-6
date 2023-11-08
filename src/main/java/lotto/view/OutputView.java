package lotto.view;

import lotto.dto.OutputDto;

import java.util.Map;

public interface OutputView {
    void view(Map<String, OutputDto> outputs);
}
