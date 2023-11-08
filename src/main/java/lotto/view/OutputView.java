package lotto.view;

import lotto.message.OutMessage;

public class OutputView {


    public void printNumberOfLotto(int numberOfLotto) {
        System.out.printf(OutMessage.OUT_NUMBER_OF_LOTTO.getMessage(), numberOfLotto);
    }

    public void printWinningStatics() {
        System.out.println(OutMessage.OUT_WINNING_STATISTICS.getMessage());
    }

    public void printTotalReturn(double totalReturn) {
        System.out.println(String.format(OutMessage.OUT_TOTAL_RETURN.getMessage(), totalReturn));
    }
}
