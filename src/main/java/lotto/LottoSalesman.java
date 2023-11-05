package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoSalesman {

    public static int lottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 오백원, 백원, 십원은 받지 않습니다. ");
        }
        int lottonumber = money / 1000;
        return lottonumber;
    }

    public static void oneLottoCreate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
    }

}
