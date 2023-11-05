package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    public static List<Integer> draw() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6) { // 상수로 치환 가능
            numbers.add(randomNumberPick());
        }
        return numbers;
    }

    public static int randomNumberPick() {
        return Randoms.pickNumberInRange(1, 45);    // 상수로 치환 가능.
    }
}
