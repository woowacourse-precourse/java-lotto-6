package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Bonus;
import lotto.domain.Purchase;
import lotto.domain.Winning;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchasePriceRequest;
import lotto.dto.request.WinningNumberRequest;
import lotto.domain.Lotto;
import lotto.domain.User;
import java.util.ArrayList;
import java.util.List;

import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;
import static lotto.configuration.GameConfiguration.LOTTO_PRICE_PER_UNIT;
import static lotto.configuration.GameConfiguration.MAX_LOTTO_NUMBER;
import static lotto.configuration.GameConfiguration.MIN_LOTTO_NUMBER;

public class LottoService {
    public User createUser(final PurchasePriceRequest purchasePriceRequest) {
        final long purchasePrice = purchasePriceRequest.getPrice();
        final Purchase purchase = new Purchase(purchasePrice);
        return new User(createLottos(purchasePrice), purchase);
    }

    public Winning createWinning(final WinningNumberRequest winningNumberRequest,
                                 final BonusNumberRequest bonusNumberRequest) {
        final Bonus bonus = new Bonus(bonusNumberRequest.getNumber());
        final List<Integer> numbers = winningNumberRequest.getNumbers();
        return new Winning(createLotto(numbers), bonus);
    }

    private Lotto createLotto(final List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private List<Lotto> createLottos(final long purchasePrice) {
        final List<Lotto> lottos = new ArrayList<>();
        final long lottoCount = purchasePrice / LOTTO_PRICE_PER_UNIT;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto(createRandomNumbers()));
        }

        return lottos;
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
