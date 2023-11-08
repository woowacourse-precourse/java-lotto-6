package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.Ranks;

import java.util.List;

public class OutputView {
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String BEFORE_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BEFORE_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public void printGetMoney() {
        System.out.println(GET_MONEY_MESSAGE);
    }
    public void printGetBonusNumber() {
        System.out.println(BEFORE_BONUS_NUMBER_MESSAGE);
    }
    public void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT_MESSAGE);
    }
    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public void printBeforeGetWinningNumber() {
        System.out.println(BEFORE_WINNING_NUMBER_MESSAGE);
    }
}
