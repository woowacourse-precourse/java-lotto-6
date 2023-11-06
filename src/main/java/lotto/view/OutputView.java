package lotto.view;


import static lotto.utils.GameMessage.IS;
import static lotto.utils.GameMessage.PURCHASED;
import static lotto.utils.GameMessage.RATE_OF_RETURN;
import static lotto.utils.GameMessage.REQUEST_AMOUNT;
import static lotto.utils.GameMessage.REQUEST_BONUS_NUMBER;
import static lotto.utils.GameMessage.REQUEST_WIN_NUMBERS;
import static lotto.utils.GameMessage.WINNING_STATISTICS;

import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.utils.Match;

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
        System.out.println(String.join(", ", String.valueOf(lotto.getNumbers())));
    }

    public void printIssuanceLotto(List<Lotto> issuanceLotto) {
        System.out.println(issuanceLotto.size() + PURCHASED.getMessage());

        for (Lotto lotto : issuanceLotto) {
            printLotto(lotto);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(LottoGame lottoGame) {
        System.out.println(WINNING_STATISTICS.getMessage());
        for (Match match : Match.values()) {
            System.out.println(
                    match.getMessage() + " (" + converterMoney(match.getPrize()) + ") - " + lottoGame.getMatchs()
                            .get(match.getMessage()) + "개");
        }
    }

    public void printRateOfReturn(Double rateOfReturn) {
        System.out.println(RATE_OF_RETURN.getMessage() + rateOfReturn + IS.getMessage());
    }

    public String converterMoney(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###원");
        return decimalFormat.format(money);
    }
}
