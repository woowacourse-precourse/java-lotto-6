package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
    private final LottoStorage lottoStorage;

    public LottoService(LottoStorage lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public void generateLotteries(BigDecimal payment) {
        int numberOfLotteries = payment.divide(new BigDecimal(1000), RoundingMode.UNNECESSARY)
                .intValueExact();
        IntStream.range(0, numberOfLotteries)
                .forEach(index -> saveLottoToStorage());
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(numbers);
    }

    private void saveLottoToStorage() {
        List<Integer> numbers = generateNumbers();
        Lotto lotto = new Lotto(numbers);
        lottoStorage.saveLotto(lotto);
    }
}
