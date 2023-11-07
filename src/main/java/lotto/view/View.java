package lotto.view;

public interface View {
    String getPurchaseAmount();

    String getWinningNumbers();

    void displayException(String message);
}
