package lotto.view;

import lotto.domain.Lotto;

import static lotto.message.OutputMessage.*;

public class OutputView {

    public void outputNewLine() {
        System.out.println();
    }

    public void outputNumberOfPurchases(int numberOfPurchases) {
        System.out.println(NUMBER_OF_PURCHASES.getMessage(numberOfPurchases));
    }

    public void outputLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void outputWinningStatistics() {
        System.out.println(WINNING_STATISTICS.getMessage());
    }

    public void outputFirstPlace(int count) {
        System.out.println(FIRST_PLACE.getMessage(count));
    }

    public void outputSecondPlace(int count) {
        System.out.println(SECOND_PLACE.getMessage(count));
    }

    public void outputThirdPlace(int count) {
        System.out.println(THIRD_PLACE.getMessage(count));
    }

    public void outputFourthPlace(int count) {
        System.out.println(FOURTH_PLACE.getMessage(count));
    }

    public void outputFifthPlace(int count) {
        System.out.println(FIFTH_PLACE.getMessage(count));
    }

    public void outputRateOfReturn(double rateOfReturn) {
        System.out.print(RATE_OF_RETURN.getMessage(rateOfReturn));
    }

    public void outputErrorMessage(String message) {
        System.out.println(message);
    }
}
