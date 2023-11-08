package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.utils.Constants.MAX_LOTTO_NUMBER;
import static lotto.utils.Constants.MIN_LOTTO_NUMBER;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    public LottoTickets buy(Money money) {
        int quantity = money.calculateQuantity(LOTTO_PRICE);
        List<Lotto> lottos = makeLottos(quantity);
        return new LottoTickets(lottos);
    }

    private List<Lotto> makeLottos(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> makeLotto())
                .toList();
    }

    private Lotto makeLotto() {
        return new Lotto(makeAutoNumbers());
    }

    private List<Integer> makeAutoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }

    public Lotto makeWinningLotto(String winningNumbers) {
        return new Lotto(makeManualNumber(winningNumbers));
    }

    private List<Integer> makeManualNumber(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
