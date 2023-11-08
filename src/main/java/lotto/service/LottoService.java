package lotto.service;

import lotto.domain.LotteryOffice;
import lotto.domain.RandomLotteryOffice;
import lotto.domain.User;

public class LottoService {
    public int sellTo(User user) {
        LotteryOffice lotteryOffice = new RandomLotteryOffice();

        int sellCount = 0;
        while (lotteryOffice.sellTo(user)) {
            sellCount++;
        };

        return sellCount;
    }
}
