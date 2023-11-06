package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {
    private final List<Lotto> lottos;

    public LottoVendingMachine() {
        lottos = new ArrayList<>();
    }

    public void purchaseLotto(int amount) {
        int lottoTicketNumber = amount / Constants.UNIT;
        createLotto(lottoTicketNumber);
    }

    private void createLotto(int lottoTicketNumber) {
        for (int i = 0; i < lottoTicketNumber; i++) {
            List<Integer> numbers = getRandomNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN, Constants.MAX, Constants.LOTTO_NUMBER_COUNT);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoTicketNumber() {
        return lottos.size();
    }
}
