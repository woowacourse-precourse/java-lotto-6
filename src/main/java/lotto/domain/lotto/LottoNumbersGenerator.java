package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottoNumbersDTO;
import lotto.domain.lotto.strategy.PickNumbersStrategy;

public class LottoNumbersGenerator {

    private final int MIN_NUMBER = LottoConfig.MIN_NUMBER.getValue();
    private final int MAX_NUMBER = LottoConfig.MAX_NUMBER.getValue();
    private final int NUMBERS_COUNT = LottoConfig.NUMBERS_COUNT.getValue();

    private final PickNumbersStrategy pickNumbersStrategy;

    public LottoNumbersGenerator(PickNumbersStrategy pickNumbersStrategy) {
        this.pickNumbersStrategy = pickNumbersStrategy;
    }

    public List<LottoNumbersDTO> generateByCount(int count) {
        return Stream.generate(this::generate)
                .limit(count)
                .toList();
    }

    public LottoNumbersDTO generate() {
        List<Integer> numbers = pickNumbersStrategy.pickNumbers(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT);
        Collections.sort(numbers);
        return new LottoNumbersDTO(numbers);
    }

}
