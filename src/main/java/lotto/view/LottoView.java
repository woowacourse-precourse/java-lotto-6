package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoWallet;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;

public interface LottoView {
    public Integer getPurchaseAmount();

    public void displayPurchased(LottoWallet lottoWallet);

    public List<Integer> getWinningNumbers();

    public Integer getBonusNumber();

    public void displayResult(List<WinningLotto> results, Float earningRate);

    public void displayError(String message);
}
