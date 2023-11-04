package lotto.view;

import lotto.constants.ErrorMessages;

public interface OutputView {
    void printLottoNumbers();
    void printGameResult();
    void printProfit();
    void printErrorMessage(String message);
}
