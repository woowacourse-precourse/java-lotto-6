package lotto.model;

import java.util.List;
import java.util.List;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

public class CreateLotto {
    private static List<Integer> lotto;
    private final static int LOTTO_COUNT = 6;
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 45;

    public CreateLotto() {

    }

    public static List<Integer> set_Lotto() {
        lotto = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_COUNT);
        Collections.sort(lotto);
        return lotto;
    }

    private void set_Price() {
        Input.set_Price();
    }
}
