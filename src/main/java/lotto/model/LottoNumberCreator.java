package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCreator {
    private static final int GENERATE_END = 0;
    private static List<Lotto> lottos = new ArrayList<>();

    private LottoNumberCreator() {
        lottos.add(
                new Lotto(
                        Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                                .sorted()
                                .toList()
                )
        );
    }

    public static List<Lotto> myLottoNumbersFrom(int each) {
        while (each-- > GENERATE_END) {
            new LottoNumberCreator();
        }
        return lottos;
    }

}
