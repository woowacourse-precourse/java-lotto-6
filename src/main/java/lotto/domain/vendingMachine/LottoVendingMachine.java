package lotto.domain.vendingMachine;

import lotto.constants.LottoConstants;
import lotto.domain.vendingMachine.cash.LottoCashManager;
import lotto.domain.vendingMachine.lotto.AutoLottoGenerator;
import lotto.domain.vendingMachine.lotto.Lotto;
import lotto.domain.vendingMachine.lotto.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVendingMachine {
    LottoGenerator lottoGenerator;
    LottoCashManager lottoCashManager = new LottoCashManager();
    public LottoVendingMachine() {
    }

    public List<Lotto> buyLotto(Integer money) {
        lottoCashManager.insertMoney(money);
        int ticketCount = calculateNumberOfLottoTicket(money);

        lottoGenerator = new AutoLottoGenerator();

        return new ArrayList<>(Collections.nCopies(ticketCount, lottoGenerator.generate()));
    }

    private Integer calculateNumberOfLottoTicket(Integer money) {
        return money / LottoConstants.LOTTO_PRICE.getValue();
    }


}
