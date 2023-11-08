package lotto.View;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    public void printGetMoney() {
        System.out.println(GET_MONEY_MESSAGE);
    }
    public void printTicketCount(int count) {
        System.out.println(count + TICKET_COUNT_MESSAGE);
    }
    public void printPurchasedLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
