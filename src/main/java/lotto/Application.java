package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        new LottoGame().start();
        System.out.println(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
