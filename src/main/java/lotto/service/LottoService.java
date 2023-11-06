package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;
import static lotto.domain.LotteryResult.SECOND;
import static lotto.domain.LotteryResult.THIRD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.LotteryNumbers;
import lotto.domain.LotteryResult;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;

/*
 *   로또 게임의 비즈니스 기능을 담당
 * */

public class LottoService {

    public List<Lotto> purchaseLottos(PurchasePrice purchasePrice) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseCount = purchasePrice.calculatePurchaseCount();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = purchaseLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto purchaseLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }

    public void checkWinningResult(Player player, LotteryNumbers lotteryNumbers) {
        List<Lotto> lottos = player.getLottos();
        List<LotteryResult> lotteryResults = lottos.stream()
                .map((lotto -> compareLotteryNumbers(lotto, lotteryNumbers)))
                .filter(LotteryResult::isWinning)
                .toList();
        player.addLotteryResult(lotteryResults);
    }

    private LotteryResult compareLotteryNumbers(Lotto lotto, LotteryNumbers lotteryNumbers) {
        Lotto winningLotto = lotteryNumbers.getWinningLotto();
        int bonusNumber = lotteryNumbers.getBonusNumber();
        int sameCount = lotto.findSameCount(winningLotto);
        LotteryResult result = LotteryResult.values()[sameCount];
        if ((result.equals(THIRD)) && (lotto.contains(bonusNumber))) {
            return SECOND;
        }
        return result;
    }
}
