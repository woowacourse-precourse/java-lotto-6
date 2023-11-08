package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Constant.*;

public class LottoBuilder {
    public LottoTicket createLotto(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = money.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(new Lotto(createRandomNumber()));
        }
        return new LottoTicket(lottoList);
    }

    private List<Integer> createRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);

        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> createWinningLotto(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
