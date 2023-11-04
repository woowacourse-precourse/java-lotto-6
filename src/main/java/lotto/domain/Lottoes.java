package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    private final List<Lotto> elements = new ArrayList<>();

    public Lottoes(int ticketCounts) {
        createLottoes(ticketCounts);
    }

    private void createLottoes(int ticketCounts) {
        for (int i = 0; i < ticketCounts; i++) {
            int start = LottoConstant.START_NUMBER.getValue();
            int end = LottoConstant.END_NUMBER.getValue();
            int count = LottoConstant.COUNT.getValue();
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
            elements.add(new Lotto(numbers));
        }
    }
}
