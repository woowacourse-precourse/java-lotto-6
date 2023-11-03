package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.service.InputService.*;
import static lotto.domain.constant.NumberConstant.*;

public class LottoService {
    public void run() {
        Long buyMoney = readExpense();
        int ticketNum = convertToTicketNum(buyMoney);
        List<Lotto> randomLottos = Lotto.createRandomLottos(ticketNum);

        Lotto winLotto = new Lotto(readWinNumbers());

    }

    private int convertToTicketNum(Long buyMoney) {
        return (int) (buyMoney / LOTTO_PRICE);
    }
}
