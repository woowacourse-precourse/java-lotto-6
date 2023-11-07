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

    public void getRandomNumber() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void showRandomNumber() {
        System.out.println(numbers.toString());
    }
}
