package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers() {
        numbers = new ArrayList<>();
    }

    public void add(LottoNumber number) {
        numbers.add(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
