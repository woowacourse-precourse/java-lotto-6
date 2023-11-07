package lotto.service;

import static lotto.common.util.LottoUtil.MAX;
import static lotto.common.util.LottoUtil.MIN;
import static lotto.common.util.LottoUtil.SIZE;
import static lotto.common.util.LottoUtil.THOUSAND;
import static lotto.common.util.LottoUtil.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.Validation;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoService {

    public Integer buyLottoCount(Integer buyPrice) {
        Validation.lottoPriceCheck(buyPrice);
        return buyPrice / THOUSAND.getNumber();
    }

    public List<Lotto> getRandomLotto(Integer buyLottoCount) {
        return IntStream.range(ZERO.getNumber(), buyLottoCount)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(MIN.getNumber(), MAX.getNumber(), SIZE.getNumber())))
                .toList();
    }

    public Buyer setBuyer(List<Lotto> randomLotto) {
        return new Buyer(randomLotto);
    }

    public WinningLotto setWinningLotto(String strLotto, String strBonus) {
        return new WinningLotto(strLotto, strBonus);
    }

}
