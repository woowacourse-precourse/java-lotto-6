package lotto.view;

import lotto.dto.LottoDto;
import lotto.dto.WinningResultDto;

import java.util.List;

public interface OutputView {

    void printUserLotto(List<LottoDto> lottoDtos);

    void printWinningResult(WinningResultDto winningResultDto);

    default void print(Object printMessage) {
        System.out.println(printMessage);
    }

    default void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
