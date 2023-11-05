package lotto.view;

import static lotto.constant.OutputText.ENTER_PURCHASE_AMOUNT;

import lotto.constant.OutputText;
import lotto.dto.LottosInfo;

public class OutputView {

    public void printEnterPurchaseAmount() {
        printOutputText(ENTER_PURCHASE_AMOUNT);
    }

    public void printLottosInfo(LottosInfo lottoInfos) {
        printText(lottoInfos.getLottoCountText());
        lottoInfos.numbers().forEach(this::printText);
    }

    private void printText(String text) {
        System.out.println(text);
    }

    private void printOutputText(OutputText outputText) {
        System.out.println(outputText.toString());
    }
}
