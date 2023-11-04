package lotto.domain.convert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConvertor {
    private final List<Integer> winNumbers;

    public static LottoConvertor from(String winNumber) {
        return new LottoConvertor(winNumber);
    }

    private LottoConvertor(String winNumbers) {
        String[] numbers = winNumbers.split(",");
        this.winNumbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinNumbers() {
        return Collections.unmodifiableList(this.winNumbers);
    }
}
