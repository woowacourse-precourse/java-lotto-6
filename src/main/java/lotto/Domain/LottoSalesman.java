package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoSalesman {

    public static int lottoCount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 오백원, 백원, 십원은 받지 않습니다.");
        }
        return money / 1000;
    }

    public static List<List<Integer>> buyLotto(int lottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = Lotto.createLottoRandomNumber();
            lottos.add(lottoNumbers);
        }
        return lottos;
    }


}
