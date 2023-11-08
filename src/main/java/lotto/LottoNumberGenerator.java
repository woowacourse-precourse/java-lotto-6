package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoNumberGenerator {

    private int ticketCount;

    public LottoNumberGenerator(int ticketCount) {
         this.ticketCount = ticketCount;
    }
    public List<Lotto> createAllLotto() {
        List<Lotto> allLottoNumbers = new ArrayList<>();
        for (int i=0; i<ticketCount; i++) {
            allLottoNumbers.add(new Lotto(createLottoNumber()));
        }
        return allLottoNumbers;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
