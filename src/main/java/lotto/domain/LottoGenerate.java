package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerate {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int PICK = 6;

    public static List<Lotto> lottos(int tickets) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < tickets) {
            lottoNumbersGenerate(lottos);
        }
        return lottos;
    }

    public static void lottoNumbersGenerate(List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, PICK);
        lottos.add(new Lotto(numbers));
    }

}
