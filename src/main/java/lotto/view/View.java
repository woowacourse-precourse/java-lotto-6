package lotto.view;
import java.util.List;

public interface View {
    int getPurchaseAmount();
    int getWinningNumbers();
    int getBonusNumber();

    void printAllLotto(List Lottos);
    void printWinningDetails();
    void printTotalReturn();

    void printError(String errorMessage);
}
