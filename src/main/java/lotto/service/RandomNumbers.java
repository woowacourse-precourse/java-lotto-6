package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    public static List<Integer> draw() {
        return randomNumberPick();
    }

    public static List<Integer> randomNumberPick() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);    // 상수로 치환 가능.
    }
}
