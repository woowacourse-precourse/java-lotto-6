package lotto.domain;

import static lotto.constant.LottoInformation.LOTTO_PRICE;
import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.LottoInformation.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {
    private final int sellCount;

    public LottoSeller(int money) throws IllegalArgumentException {
        this.sellCount = money / LOTTO_PRICE;
    }

    public List<Lotto> makeLottoTickets() {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < sellCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottoTickets.add(new Lotto(numbers));
        }
        return Collections.unmodifiableList(lottoTickets);
    }
}
