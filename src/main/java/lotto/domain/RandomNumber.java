package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.messages.Constant.*;

public class RandomNumber {

    private final List<Integer> randomNumbers;

    public RandomNumber(List<Integer> randomNumber) {
        this.randomNumbers = randomNumber;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    @Override
    public String toString() {
        return randomNumbers.toString();
    }

    public static List<Integer> getUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT).stream().sorted().toList();
    }
}
