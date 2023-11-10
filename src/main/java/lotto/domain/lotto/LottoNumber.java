package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_CNT = 6;

    private static List<Integer> lottoNumbers;

    public LottoNumber() {
    }

    public static List<Integer> setLottoNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_CNT);
        List<Integer> lottoTicketNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoTicketNumbers);
        return lottoTicketNumbers;
    }
}
