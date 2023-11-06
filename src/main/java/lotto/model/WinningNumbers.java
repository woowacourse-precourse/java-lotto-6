package lotto.model;

import java.util.HashMap;
import java.util.List;

public class WinningNumbers extends Lotto{
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(List<Integer> numbers, int bonusNumber){
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
        }
        for (int num : numbers){
            if (bonusNumber == num){
                throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
            }
        }
    }



}
