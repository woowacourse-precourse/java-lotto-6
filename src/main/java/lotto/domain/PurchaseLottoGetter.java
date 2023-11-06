package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class PurchaseLottoGetter implements RandomGetter {
    @Override
    public List<Integer> getRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
