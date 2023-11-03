package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> roulette(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int quantity = money / 1000;
        while (lottos.size() != quantity) {
            lottos.add(new Lotto(makeRandomNumbers()));
        }

        return lottos;
    }

    private static List<Integer> makeRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
