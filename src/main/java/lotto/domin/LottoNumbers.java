package lotto.domin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoNumberList;

    public List<Integer> LottoNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        ArrayList<Integer> lottoTicketNumbers = new ArrayList<>(lottoNumberList);
        return lottoTicketNumbers;
    }

}
