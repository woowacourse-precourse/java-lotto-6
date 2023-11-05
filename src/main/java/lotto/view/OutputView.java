package lotto.view;

import static lotto.utils.GameMessage.REQUEST_AMOUNT;
import static lotto.utils.GameMessage.REQUEST_BONUS_NUMBER;
import static lotto.utils.GameMessage.REQUEST_WIN_NUMBERS;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public void printRequestAmount() {
        System.out.println(REQUEST_AMOUNT.getMessage());
    }

    public void printRequestWinNumbers() {
        System.out.println(REQUEST_WIN_NUMBERS.getMessage());
    }

    public void printRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
    }

    public void printLotto(Lotto lotto) {
        System.out.println("[" + String.join(", ", String.valueOf(lotto.getNumbers())) + "]");
    }

    public void printIssuanceLotto(List<Lotto> issuanceLotto) {
        for (Lotto lotto : issuanceLotto) {
            printLotto(lotto);
        }
    }
}
