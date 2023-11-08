package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.CommonLotto;

public class LottoNumbers {
    public static List<Integer> lottoNumberList;

    public static List<Integer> createRandomNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(CommonLotto.LOTTO_MIN, CommonLotto.MAX_NUMBER,
                CommonLotto.LOTTO_COUNT);
        List<Integer> lottoTicketNumberList = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoTicketNumberList);
        return lottoTicketNumberList;
    }
}
