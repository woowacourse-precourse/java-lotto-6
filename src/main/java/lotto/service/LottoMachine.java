package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.constant.LOTTO_PURCHASED_UNIT;


public class LottoMachine {
    public List<Lotto> roulette(int money) {
        List<Lotto> lottos = new ArrayList<>();

        int quantity = money / LOTTO_PURCHASED_UNIT;
        while (lottos.size() != quantity) {
            lottos.add(new Lotto(sort(makeRandomNumbers())));
        }

        return lottos;
    }

    private static List<Integer> makeRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    private static List<Integer> sort(List<Integer> numbers) {
        return new ArrayList<>(numbers)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
