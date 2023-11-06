package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
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

    public void test() {
        System.out.println(numbers);
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
