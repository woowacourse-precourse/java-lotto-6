package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDto {

    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getNumbers());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
