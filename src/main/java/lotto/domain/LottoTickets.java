package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int LOTTO_LENGTH = 6;

    private List<Lotto> lottoTickets;

    public LottoTickets(int quantity) {
        lottoTickets = new ArrayList<>();
        lottoTicketsGenerator(quantity);
    }

    private void lottoTicketsGenerator(int quantity) {
        for (int i = 0; i < quantity; i++) {
            generateLotto();
        }
    }

    private void generateLotto() {
        List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
        lottoTickets.add(new Lotto(randomLottoNumber));
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
