package lotto.Input;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class GenerateLottos {
    public static List<Lotto> generateLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++) {
            Lotto lotto = LottoGenerator.createRandomLotto();
            lotto.printLotto();
            lottos.add(lotto);
        }
        System.out.println();
        return lottos;
    }
}
