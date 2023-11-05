package lotto.view;
import java.util.List;

public interface View {
    String getPurchaseAmount();
    String getWinningNumbers();
    String getBonusNumber();

    void printAllLotto(List lottos);
    void printWinningDetails(List scores);
    void printTotalReturn(float totalReturn);

    void printError(String errorMessage);
}
