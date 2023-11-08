package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public Lotto createLottoTicket() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
            lottoNumbers.add(randomNumber);
        }

        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLottoNumbers);
        return new Lotto(sortedLottoNumbers);
    }

}
