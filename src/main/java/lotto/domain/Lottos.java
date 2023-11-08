package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoNumbers;

    public Lottos() {
    }

    public static List<Integer> setRandomNumbers() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        List<Integer> lottoTicket = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoTicket);
        return lottoTicket;
    }
}
