package lotto.view;

import lotto.model.Lotto;

public class OutputLotto {

    //[8, 21, 23, 41, 42, 43] 형식으로 출력
    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
