package lotto.game;

import static lotto.Constants.LottoConstant.*;
import static lotto.Constants.MessageConstant.BUY_LOTTO;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.AmountToBuyLotto;
import lotto.WinningNumber;
import lotto.WinningStatistic;
import lotto.YieldRate;
import lotto.random.RandomNumberGenerator;

public class LottoGame {


    private final List<Lotto> issuedLottos;
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        issuedLottos = new ArrayList<>();
    }

    public void saleLotto(AmountToBuyLotto amountToBuyLotto) {
        int totalCount = amountToBuyLotto.dividedByLottoPrice(LOTTO_PRICE);
        for (int current = INIT_COUNT; current < totalCount; current++) {
            issuedLottos.add(createLotto());
        }
    }

    private Lotto createLotto() {
        return new Lotto(randomNumberGenerator.generateRandomNumbers());
    }


}
