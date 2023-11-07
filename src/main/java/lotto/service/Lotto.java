package lotto.service;

import java.util.List;

import static lotto.service.validator.LottoValidator.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //만약 예외 발생시 컨트롤러에서 예외발생시 재입력 처리를 해줘야함
        winningNumberValidate(numbers);
        this.numbers = numbers;
    }
    public void isContainNumber(int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
