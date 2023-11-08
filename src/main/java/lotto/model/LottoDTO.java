package lotto.model;

import static lotto.util.Constants.ERROR;

import java.util.List;

public class LottoDTO {
    private final List<Integer> numbers;

    private LottoDTO(){
        throw new AssertionError(ERROR + "기본 생성자로 생성할 수 없습니다.");
    }

    public LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
