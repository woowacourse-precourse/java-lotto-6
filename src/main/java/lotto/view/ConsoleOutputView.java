package lotto.view;

import static lotto.view.LottoGameMessage.COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.view.LottoGameMessage.REQUEST_WINNING_LOTTO_NUMBERS;

import lotto.dto.LottoNumbersDTO;

public class ConsoleOutputView {
    public void requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
    }

    public void printCountOfLotto(int count) {
        printBlankLine();
        System.out.printf(COUNT_OF_PURCHASED_LOTTO.getMessage(), count);
        printBlankLine();
    }

    public void printLottoNumbers(LottoNumbersDTO lottoNumbers) {
        System.out.println(lottoNumbers.getFormattedLottoNumbers());
    }

    public void requestWinningLottoNumbers() {
        printBlankLine();
        System.out.println(REQUEST_WINNING_LOTTO_NUMBERS.getMessage());
    }

    private void printBlankLine() {
        System.out.println();
    }
}
