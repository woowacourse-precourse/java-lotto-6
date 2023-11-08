package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import java.util.ArrayList;
import java.util.List;

public class GenerateLotto {
    
    public static List<Lotto> generateLottoList(int LottoCount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < LottoCount; i++) {
            lottoList.add(generateLotto());
        }

        return lottoList;
    }

    private static Lotto generateLotto() {

        try{
            return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        catch (IllegalArgumentException e){
            return generateLotto();
        }

    }

}
