package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumber {
    private List<Integer> numbers;
    public RandomLottoNumber() {
        getRandomNumber();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void getRandomNumber() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
