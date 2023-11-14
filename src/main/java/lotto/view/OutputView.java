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

    public void outputLottoResult() {
        printlnOut("");
        printlnOut(OutputMessage.LOTTO_RESULT
                .getMessage());
    }

    public void outputRankFiveResult(int result) {
        printlnOut(OutputMessage.RANK_FIVE_RESULT.getMessage(result));
    }

    public void outputRankFourResult(int result) {
        printlnOut(OutputMessage.RANK_FOUR_RESULT.getMessage(result));
    }

    public void outputRankThreeResult(int result) {
        printlnOut(OutputMessage.RANK_THREE_RESULT.getMessage(result));
    }

    public void outputRankTwoResult(int result) {
        printlnOut(OutputMessage.RANK_TWO_RESULT.getMessage(result));
    }

    public void outputRankOneResult(int result) {
        printlnOut(OutputMessage.RANK_ONE_RESULT.getMessage(result));
    }

    public void outputRate(double result) {
        printlnOut(OutputMessage.RATE.getMessage(result));
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }
}
