package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoNumbersDto {

    private final List<List<Integer>> lottosNumbers;

    public LottoNumbersDto(final List<List<Integer>> lottosNumbers) {
        this.lottosNumbers = lottosNumbers;
    }

    public List<List<Integer>> getLottosNumbers() {
        return Collections.unmodifiableList(lottosNumbers);
    }

}
