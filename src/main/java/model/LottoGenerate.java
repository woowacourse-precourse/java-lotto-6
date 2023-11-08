package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerate {
    private static int lottoTicketsCount(int moneyNumber) {
        return moneyNumber / 1000;
    }

    private static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private static Lotto lottoAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private static List<Lotto> generateLottoTickets(int lottoTicketsCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 1; i <= lottoTicketsCount; i++) {
            List<Integer> numbers = generateLotto();
            Lotto lotto = lottoAscendingOrder(numbers);
            lottoTickets.add(lotto);
        }
    }
}
