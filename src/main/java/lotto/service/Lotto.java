package lotto.service;

import java.util.List;

import static lotto.service.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //만약 예외 발생시 컨트롤러에서 예외발생시 재입력 처리를 해줘야함
        winningNumberValidate(numbers);
        this.numbers = numbers;
    }
    public void setBonusNumber(List<Integer> bonusNumber) { //보너스를 추가했는데 예외 발생시 컨트롤러에서 재입력 처리해줘야함.
        numbers.addAll(bonusNumber);
        bonusNumberValidate(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
