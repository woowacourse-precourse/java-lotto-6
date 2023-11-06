package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 입력된 숫자의 갯수가 6개가 아닙니다.");
        }
    }

    private void checkDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numberList = new HashSet<>(numbers);
        if (numberList.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] : 입력된 숫자 내부에 중복된 값이 존재합니다.");
        }
    }

    public void checkDuplicateForBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력된 보너스 번호가 기존 당첨 번호와 중복됩니다.");
        }
    }

    public int checkWinning(ArrayList<Integer> lottoNumbers, int bonusNumber) {
        int correct = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (numbers.contains(lottoNumber)) {
                correct += 1;
            }
        }
        if (correct == 5 && lottoNumbers.contains(bonusNumber)) {
            correct = 7;
        }
        return correct;
    }


}
