package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
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
        return new Lotto(makeLottoNumbers());
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }

    public Lotto makeWinningLotto(String winningNumbers) {
        return new Lotto(makeLottoNumber(winningNumbers));
    }

    private List<Integer> makeLottoNumber(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
