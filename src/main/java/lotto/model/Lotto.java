package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import lotto.view.OutputView;

public class Lotto {
    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 45;
    final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int getNumber(int idx) {
        return this.numbers.get(idx);
    }

    public List<Integer> getLotto () {
        return this.numbers;
    }
    public int countMatch (Lotto answers, int bonus) {
        int result = 0;
        for(int i = 0; i < this.numbers.size(); i++) {
            if(isContain(answers.getNumber(i))) {
                result++;
            }
        }

        if(result == 5 && isContain(bonus)) {
            result=-1;
        }

        return result;
    }
    private boolean isContain (int num) {
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) == num) {
                return true;
            }
        }
        return false;
    }
}
