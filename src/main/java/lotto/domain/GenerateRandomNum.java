package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNum {

    public static int pickNumber() {
        int num = Randoms.pickNumberInRange(1, 45);
        checkNumberInRange(num);
        return num;
    }

    private static void checkNumberInRange(int num) {
        if (num < 1 || num > 45) throw new IllegalArgumentException("숫자는 1과 45사이의 범위안에 있어야 합니다.");
    }
}
