package lotto.view;

import lotto.common.util.OutputMessage;

public class OutputView {

    public void outputStartMessage() {
        printlnOut(OutputMessage.START
                .getMessage());
    }

    public void outputLottoCountMessage(Integer buyLottoCount) {
        printlnOut("");
        printlnOut(buyLottoCount + OutputMessage.COUNT
                .getMessage());
    }

    public void outputLottoMessage(String lotto) {
        printlnOut("[" + lotto + "]");
    }

    public void inputLottoNumber() {
        printlnOut("");
        printlnOut(OutputMessage.LOTTO_NUMBER
                .getMessage());
    }

    public void inputBonusNumber() {
        printlnOut("");
        printlnOut(OutputMessage.BONUS
                .getMessage());
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }

}
