package lotto.Input;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> lottoTicket;


    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public LottoNumbers() {
        this.lottoTicket = makeLottoTicket();
    }

    public List<Integer> getLottoTicket() {
        return lottoTicket;
    }

    public List<Integer> makeLottoTicket() {
        List<Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, CNT_LOTTO_NUMBER);
        List<Integer> numbers = new ArrayList<>(immutableNumbers);
        numbers.sort(Integer::compareTo);

        return numbers;
    }
}
