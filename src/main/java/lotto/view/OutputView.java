package lotto.view;

import static lotto.utils.GameMessage.BONUS_MATCH;
import static lotto.utils.GameMessage.BONUS_PRIZE;
import static lotto.utils.GameMessage.COUNT;
import static lotto.utils.GameMessage.DELIMITER;
import static lotto.utils.GameMessage.FIVE_MATCH;
import static lotto.utils.GameMessage.FIVE_PRIZE;
import static lotto.utils.GameMessage.FOUR_MATCH;
import static lotto.utils.GameMessage.FOUR_PRIZE;
import static lotto.utils.GameMessage.IS;
import static lotto.utils.GameMessage.PURCHASED;
import static lotto.utils.GameMessage.RATE_OF_RETURN;
import static lotto.utils.GameMessage.REQUEST_AMOUNT;
import static lotto.utils.GameMessage.REQUEST_BONUS_NUMBER;
import static lotto.utils.GameMessage.REQUEST_WIN_NUMBERS;
import static lotto.utils.GameMessage.SIX_MATCH;
import static lotto.utils.GameMessage.SIX_PRIZE;
import static lotto.utils.GameMessage.THREE_MATCH;
import static lotto.utils.GameMessage.THREE_PRIZE;
import static lotto.utils.GameMessage.WINNING_STATISTICS;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGame;

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
        System.out.println(String.join(DELIMITER.getMessage(), String.valueOf(lotto.getNumbers())));
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
        System.out.println(THREE_MATCH.getMessage() + THREE_PRIZE.getMessage() + lottoGame.getMatchs()
                .get(THREE_MATCH.getMessage()) + COUNT.getMessage());
        System.out.println(
                FOUR_MATCH.getMessage() + FOUR_PRIZE.getMessage() + lottoGame.getMatchs().get(FOUR_MATCH.getMessage())
                        + COUNT.getMessage());
        System.out.println(
                FIVE_MATCH.getMessage() + FIVE_PRIZE.getMessage() + lottoGame.getMatchs().get(FIVE_MATCH.getMessage())
                        + COUNT.getMessage());
        System.out.println(BONUS_MATCH.getMessage() + BONUS_PRIZE.getMessage() + lottoGame.getMatchs()
                .get(BONUS_MATCH.getMessage()) + COUNT.getMessage());
        System.out.println(
                SIX_MATCH.getMessage() + SIX_PRIZE.getMessage() + lottoGame.getMatchs().get(SIX_MATCH.getMessage())
                        + COUNT.getMessage());
    }

    public void printRateOfReturn(Double rateOfReturn) {
        System.out.println(RATE_OF_RETURN.getMessage() + rateOfReturn + IS.getMessage());
    }
}
