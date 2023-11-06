package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private final LottoStorage lottoStorage;

    public LottoService(LottoStorage lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public List<Lotto> generateLotteries(BigDecimal payment) {
        int numberOfLotteries = payment.divide(new BigDecimal(1000), RoundingMode.UNNECESSARY)
                .intValueExact();
        return IntStream.range(0, numberOfLotteries)
                .mapToObj(index -> saveLottoToStorage())
                .toList();
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream()
                .sorted()
                .toList();
    }

    private Lotto saveLottoToStorage() {
        List<Integer> numbers = generateNumbers();
        Lotto lotto = new Lotto(numbers);
        return lottoStorage.saveLotto(lotto);
    }
}
