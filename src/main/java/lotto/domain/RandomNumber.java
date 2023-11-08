package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {
    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    public static final int LOTTO_NUM_LENGTH = 6;

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }
    public RandomNumber(){
        this.numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_NUM_LENGTH);
    }
}
