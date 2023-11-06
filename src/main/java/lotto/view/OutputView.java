package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {
    public void showWinningStatics() {
        System.out.println(OutputMessage.SHOW_RESULT.getOutputMessage());
        System.out.println(OutputMessage.DIVIDING_LINE.getOutputMessage());
    }

    public void showThreeWinning(int count) {
        System.out.println(OutputMessage.THREE_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    public void showFourWinning(int count) {
        System.out.println(OutputMessage.FOUR_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    public void showFiveWinning(int count) {
        System.out.println(OutputMessage.FIVE_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    public void showFiveWithBonusWinning(int count) {
        System.out.println(OutputMessage.FIVE_WIN_WITH_BONUS_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }

    public void showLottoWinning(int count) {
        System.out.println(OutputMessage.LOTTO_WIN_MESSAGE.getOutputMessage());
        System.out.println(count + "개");
    }
}
