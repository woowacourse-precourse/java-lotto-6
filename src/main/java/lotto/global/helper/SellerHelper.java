package lotto.global.helper;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoCondition;
import lotto.domain.Result;
import lotto.global.Prize;
import lotto.global.util.Util;

public class SellerHelper {

    public static List<Lotto> buyLottos(Integer count) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        while (count-- > 0) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoCondition.MIN_NUMBER, LottoCondition.MAX_NUMBER, LottoCondition.NUMBER_COUNT);
            lottos.add(new Lotto(Util.sortAsc(lottoNumbers)));
        }
        return lottos;
    }

    public static Result compareAndRecord(List<Lotto> lottos, Lotto win, Integer bonusNumber) {
        Result result = new Result();
        lottos.forEach(lotto -> {
            Prize prize = win.compare(lotto.getNumbers(), bonusNumber);
            result.record(prize);
        });
        return result;
    }
}
