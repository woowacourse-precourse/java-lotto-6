package lotto;

import static lotto.Application.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수를 로또 번호로 갖을 수 없습니다.");
        }
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 번호는 " + LOTTO_NUMBER_COUNT + "자리여야 합니다.");
        }
    }

    private static boolean isDuplicated(List<LottoNumber> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumbersValue() {
        List<Integer> values = new ArrayList<>();
        for (LottoNumber lottoNumber : numbers) {
            int lottoNumberValue = lottoNumber.getNumber();
            values.add(lottoNumberValue);
        }
        return values;
    }
}
