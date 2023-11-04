package lotto.view;

import static lotto.view.LottoGameMessage.COUNT_OF_PURCHASED_LOTTO;
import static lotto.view.LottoGameMessage.REQUEST_PURCHASE_AMOUNT;

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

    private void printBlankLine() {
        System.out.println();
    }
}
