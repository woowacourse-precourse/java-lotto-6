package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;
    public static List<Lotto> lottoIssuance(int amount){
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount/LOTTO_PRICE; i++) {
            lottos.add(new Lotto(generateRandomLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }




}
