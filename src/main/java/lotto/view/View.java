package lotto.view;

public interface View {
    String getPurchaseAmount();

    String getWinningNumbers();

    String getBonusNumber();

    void displayException(String message);
}
