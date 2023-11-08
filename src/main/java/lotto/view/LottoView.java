package lotto.view;

import java.util.HashMap;
import lotto.domain.LottoWallet;

public interface LottoView {
    public Integer getPurchaseAmount();

    public void displayPurchased(LottoWallet lottoWallet);

    public String getWinningNumbers();

    public String getBonusNumber();

    public void displayResult(HashMap<String, Integer> result);

    public void displayError(String message);
}
