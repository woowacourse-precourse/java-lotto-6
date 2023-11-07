package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private static final int REMAINDER_ZERO = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBERS_MINIMUM = 1;
    private static final int LOTTO_NUMBERS_MAXIMUM = 45;

    private final List<Lotto> lottoTickets;

    public LottoTickets(int purchaseAmount) {
        validateDivisibleByLottoPrice(purchaseAmount);
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        lottoTickets = new ArrayList<>();
        publishLottoTickets(lottoCount);
    }

    private void validateDivisibleByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE > REMAINDER_ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다. 1,000원단위로 입력해주세요.");
        }
    }

    private void publishLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLottoByRandomNumbers());
        }
    }

    private Lotto createLottoByRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBERS_MINIMUM, LOTTO_NUMBERS_MAXIMUM, LOTTO_NUMBERS_SIZE);
        return new Lotto(randomNumbers);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
