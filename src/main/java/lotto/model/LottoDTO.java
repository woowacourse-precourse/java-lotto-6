package lotto.model;

import static lotto.util.Constants.ERROR;

import java.util.List;
import lotto.util.exception.input.ConstructionErrorException;

public class LottoDTO {
    private final List<Integer> numbers;

    private LottoDTO(){
        throw new ConstructionErrorException();
    }

    public LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
