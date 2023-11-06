package lotto.io;

import lotto.domain.dto.Statistics;

import java.util.List;

public interface OutputPort {
    void printErrorMessage(String message);
    void printInputPurchaseAmount();
    void printNumberOfLottos(Integer numberOfLottos);
    void printCreatedLottos(List<List<Integer>> lottos);
    void printInputWinningNumbers();
    void printInputBonusNumber();
    void printStatistics(Statistics statistics);
}
