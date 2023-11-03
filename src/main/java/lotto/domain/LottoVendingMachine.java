package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {
    private final List<Lotto> lottos;
    private int lottoTicketNumber;

    public LottoVendingMachine() {
        lottos = new ArrayList<>();
    }

    public void purchaseLotto(int amount) {
        lottoTicketNumber = amount / 1000;
        for (int i = 0; i < lottoTicketNumber; i++) {
            List<Integer> numbers = getRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getLottoTicketNumber() {
        return lottoTicketNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
