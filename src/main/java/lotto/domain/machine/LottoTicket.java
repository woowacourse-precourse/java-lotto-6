package lotto.domain.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    public static List<Integer> drawLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        if (lottoNumbers.stream().distinct() != lottoNumbers) {
            return drawLottoTicket();
        }
        return lottoNumbers;
    }
}
