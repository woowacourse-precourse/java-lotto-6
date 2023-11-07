package controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtility {
    public void generateRandomLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(randomNumbers);
    }
}
