package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

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
