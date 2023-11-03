package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    public static List<Integer> numbers = new ArrayList<>();

    public void draw() {
        while(numbers.size() < 6) { // 상수로 치환 가능
            numbers.add(randomNumberPick());
        }
    }

    public int randomNumberPick() {
        return Randoms.pickNumberInRange(1, 45);    // 상수로 치환 가능.
    }
}
