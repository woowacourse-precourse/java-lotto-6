package lotto.view;

import java.util.HashMap;

public interface LottoView {
    public Integer getPurchaseAmount();

    public void displayPurchased();

    public String getWinningNumbers();

    public String getBonusNumber();

    public void displayResult(HashMap<String, Integer> result);

    public void displayError(String message);
}
