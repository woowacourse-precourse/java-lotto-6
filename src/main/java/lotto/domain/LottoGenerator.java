package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private List<Lotto> lottoes = new ArrayList<>();

    private static List<Integer> pickSixRandomNumbersByAscendingOrder() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_START, Lotto.LOTTO_NUMBER_END,
                Lotto.LOTTO_NUMBER_COUNT);
        return numbers;
    }

    public List<Lotto> generateLottoes(Amount amount) {
        int count = amount.getAmount() / Lotto.PRICE;
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = pickSixRandomNumbersByAscendingOrder();
            lottoes.add(new Lotto(numbers));
        }
        return lottoes;
    }

}
