package lotto.io;

import java.util.List;

public interface OutputPort {
    void printErrorMessage(String message);
    void printInputPurchaseAmount();
    void printNumberOfLottos(Integer numberOfLottos);
    void printCreatedLottos(List<List<Integer>> lottos);
    void printInputWinningNumbers();
    void printInputBonusNumber();
    void printStatistics(double statistics);
}
