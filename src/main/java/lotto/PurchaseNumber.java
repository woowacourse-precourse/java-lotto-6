package lotto;

import static lotto.Application.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class PurchaseNumber {

    private List<LottoNumber> numbers;

    public PurchaseNumber(List<LottoNumber> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 수를 로또 번호로 갖을 수 없습니다.");
        }
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 번호는 " + LOTTO_NUMBER_COUNT + "자리여야 합니다.");
        }
        this.numbers = numbers;
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
