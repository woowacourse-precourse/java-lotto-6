package lotto.view;

import static lotto.constant.OutputText.ENTER_BONUS_NUMBER;
import static lotto.constant.OutputText.ENTER_PURCHASE_AMOUNT;
import static lotto.constant.OutputText.ENTER_WINNING_NUMBERS;

import lotto.constant.OutputText;
import lotto.dto.LottosInfo;

public class OutputView {

    public void printEnterPurchaseAmount() {
        printOutputText(ENTER_PURCHASE_AMOUNT);
    }

    public void printEnterWinningNumbers() {
        printOutputText(ENTER_WINNING_NUMBERS);
    }

    public void printEnterBonusNumber() {
        printOutputText(ENTER_BONUS_NUMBER);
    }

    public void printLottosInfo(LottosInfo lottoInfos) {
        printText(lottoInfos.getLottoCountText());
        lottoInfos.numbers().forEach(this::printText);
        printSpace();
    }

    private void printSpace() {
        System.out.println();
    }

    private void printText(String text) {
        System.out.println(text);
    }

    private void printOutputText(OutputText outputText) {
        System.out.println(outputText.toString());
    }
}
