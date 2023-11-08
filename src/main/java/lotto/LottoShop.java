package lotto;

import lotto.Lotto;
import lotto.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;
    public static final String ERROR_MESSAGE = "[ERROR] 1000원 이상을 입력하세요.";

    public LottoTicket buyLottoTicket(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        int numOfTickets = amount / LOTTO_PRICE;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            Lotto lotto = Lotto.createRandomLotto();
            tickets.add(lotto);
        }

        return new LottoTicket(tickets);
    }
}
