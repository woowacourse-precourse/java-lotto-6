package lotto.service;

import java.util.List;

import static lotto.service.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        winningNumberValidate(numbers);
        this.numbers = numbers;
    }

    public void isContainNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalStateException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
