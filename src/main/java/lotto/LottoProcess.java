package lotto;

import static lotto.Enum.Number.SIX;
import static lotto.Enum.Number.MAX_NUMBER;
import static lotto.Enum.Number.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
    private static List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(), SIX.getNumber());
    }

    public static List<Lotto> publishLotto(int countLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLotto; i++) {
            Lotto lotto = new Lotto(createRandomLottoNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void printLotto(List<Lotto> lottos, int countLotto) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
