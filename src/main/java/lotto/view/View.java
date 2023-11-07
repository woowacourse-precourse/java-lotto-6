package lotto.view;

import lotto.model.Lotto;
import lotto.model.Ranking;

import java.util.List;

public interface View {
    String getPurchaseAmount();

    String getWinningNumbers();

    String getBonusNumber();

    void printAllLottery(List<Lotto> lotteries);

    void printScoreDetails(List<Ranking> ranks);

    void printTotalReturn(float totalReturn);

    void printError(String errorMessage);
}
