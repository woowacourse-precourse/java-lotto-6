package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public interface View {
    String getPurchaseAmount();

    String getWinningNumbers();

    String getBonusNumber();

    void printAllLottery(List<Lotto> lotteries);

    void printScoreDetails(List<Integer> scores);

    void printTotalReturn(float totalReturn);

    void printError(String errorMessage);
}
