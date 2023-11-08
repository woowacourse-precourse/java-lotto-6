package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class LottoMachine {

    private static LottoMachine lottoMachine = new LottoMachine();

    private LottoMachine() {
    }

    public static LottoMachine getInstance() {
        return lottoMachine;
    }

    public List<Lotto> produceLottos(int price) {
        int number = price / LOTTO_TICKET_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS_SIZE);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            lottos.add(new Lotto(sortedNumbers));
        }
        return lottos;
    }
}
