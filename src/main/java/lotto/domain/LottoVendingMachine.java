package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoVendingMachine {
    private int lottoTicketNumber;

    public LottoVendingMachine() {
    }

    public void purchaseLotto(int amount) {
        lottoTicketNumber = amount / 1000;
        List<Integer> numbers = getRandomNumbers();
    }

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getLottoTicketNumber() {
        return lottoTicketNumber;
    }
}
