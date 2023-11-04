package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class Computer {

    public static String getInput() {
        return Console.readLine();
    }
    public static Lotto generateLotto() {

        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));

    }


}
