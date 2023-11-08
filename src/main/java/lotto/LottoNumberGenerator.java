package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int NUMBERS_PER_LOTTO = 6;
    
    public static List<Lotto> generateLottoTicket(int ticketCount) {
        List<Lotto> lottoTicket = new ArrayList<Lotto>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = generateLotto();
            lottoTicket.add(lotto);
        }
        return lottoTicket;
    }
    
    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBERS_PER_LOTTO);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
    
}
