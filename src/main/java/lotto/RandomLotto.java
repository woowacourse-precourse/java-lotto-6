package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLotto {

    private static List<Integer> randomLottoNums;

    public static List<Integer> setRandomLotto() {
        randomLottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> lottoTicketNums = new ArrayList<>(randomLottoNums);
        Collections.sort(lottoTicketNums);
        return lottoTicketNums;
    }


}
