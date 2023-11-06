package lotto.view;

import java.util.List;
import lotto.domain.Money;

public class LottoView {
    public static final String ERROR = "[ERROR] ";

    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();

    public Money getLottoPurchase() {
        Money money;
        do {
            money = inputView.getLottoPurchase();
        } while (money == null);

        return money;
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        do {
            winningNumbers = inputView.getWinningNumbers();
        } while (winningNumbers.isEmpty());

        return winningNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber;
        do {
            bonusNumber = inputView.getBonusNumber();
        } while (bonusNumber == 0);

        return bonusNumber;
    }

}
