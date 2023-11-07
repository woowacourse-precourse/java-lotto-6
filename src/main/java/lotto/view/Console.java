package lotto.view;

import java.util.List;

public interface Console {
    String inputPayment();

    void displayPurchasedLotteryCount(int lotteryCount);

    void displayPurchasedLottery(List<Integer> lottery);

    String inputWinningNumbers();

    String inputBonusNumber();

    void displayResult(List<Integer> matchResult, double rateOfReturn);
}
