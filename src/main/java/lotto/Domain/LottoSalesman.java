package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoSalesman {

    public static int lottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 오백원, 백원, 십원은 받지 않습니다.");
        }
        return money / 1000;
    }

}
