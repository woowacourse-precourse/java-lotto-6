package lotto;

import static lotto.Application.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        checkDuplicated(numbers, bonusNumber);
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LOTTO_NUMBER_COUNT + "자리여야 합니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private static void checkDuplicated(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 넘버는 로또 안에 있는 수와 중복될 수 없습니다.");
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException("[ERROR] 중복된 수를 로또 번호로 갖을 수 없습니다.");
                }
            }
        }
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

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public int getBonusNumberValue() {
        return bonusNumber.getNumber();
    }
}