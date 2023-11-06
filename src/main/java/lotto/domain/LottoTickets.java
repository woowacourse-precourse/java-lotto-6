package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int purchaseAmount) {
        validateDivisibleByLottoPrice(purchaseAmount);
        int lottoCount = purchaseAmount / 1000;
        lottoTickets = new ArrayList<>();
        publishLottoTickets(lottoCount);
    }

    private void validateDivisibleByLottoPrice(int purchaseAmount) {
        if (purchaseAmount % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 로또 1장의 가격은 1,000원입니다. 1,000원단위로 입력해주세요.");
        }
    }

    private void publishLottoTickets(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(createLottoByRandomNumbers());
        }
    }

    private Lotto createLottoByRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
