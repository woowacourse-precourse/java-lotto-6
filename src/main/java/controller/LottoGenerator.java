package controller;

import camp.nextstep.edu.missionutils.Randoms;
import model.Lotto;
import static model.LottoInit.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int ZERO = 0;

    public static List<Lotto> createLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        while (number > ZERO) {
            List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange
                    (LOTTO_MINIMUM.getInitial(), LOTTO_MAXIMUM.getInitial(), LOTTO_SIZE.getInitial()));
            Lotto lotto = new Lotto(randomNumber);
            lottos.add(lotto);
            number--;
        }

        return lottos;
    }


}
