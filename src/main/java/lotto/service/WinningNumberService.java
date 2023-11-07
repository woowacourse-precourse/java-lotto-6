package lotto.service;

import static lotto.constant.LottoResult.*;

import java.util.List;
import java.util.function.Predicate;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResultCount;
import lotto.domain.LottoWinningNumber;
import lotto.util.ValidationUtil;

public class WinningNumberService {
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final ValidationUtil validationUtil = new ValidationUtil();
    private final LottoResultCount lottoResultCount = new LottoResultCount();

    public void getInputWinningSixNumber(String number) {
        lottoWinningNumber.getWinningSixNumbersInfo(validationUtil.validateWinningNumber(number));
    }

    public void getInputWinningNumber(String bonusNum) {
        List<Integer> winning = lottoWinningNumber.getWinningNums();
        int bonus = validationUtil.validateWinningNumberWithBonus(bonusNum, winning);
        lottoWinningNumber.getWinningBonusNumbersInfo(bonus);
    }

    public void getLottoWinningResult(LottoPurchase lottoPurchase, ResultService resultService) {
        for (Lotto lotto : lottoPurchase.getPurchaseLotto()) {
            List<Integer> LottoNums = lotto.getLottoNumbers();
            int matchCount = getMatchCount(LottoNums);
            addMatchCount(checkBonusNumber(LottoNums, matchCount));
        }
        resultService.createResultService(lottoResultCount, lottoPurchase.getAmount());
    }

    private int getMatchCount(List<Integer> userNums) {
        return Long.valueOf(lottoWinningNumber.getWinningNums()
                .stream()
                .filter(lottoNum -> userNums.stream()
                        .anyMatch(Predicate.isEqual(lottoNum)))
                .count()).intValue();
    }

    private int checkBonusNumber(List<Integer> userNums, int matchCount) {
        if (matchCount == FIVE_COUNT.getPrizeCount() && userNums.contains(lottoWinningNumber.getBonusNum())) {
            int NONCE = 10;
            return matchCount * NONCE;
        }

        return matchCount;
    }

    private void addMatchCount(int matchCount) {
        if (matchCount == THREE_COUNT.getPrizeCount()) {
            lottoResultCount.addThreeCount();
        }
        if (matchCount == FOUR_COUNT.getPrizeCount()) {
            lottoResultCount.addFourCount();
        }
        if (matchCount == FIVE_COUNT.getPrizeCount()) {
            lottoResultCount.addFiveCount();
        }
        if (matchCount == FIVE_COUNT_WITH_BONUS.getPrizeCount()) {
            lottoResultCount.addFiveWithBonusCount();
        }
        if (matchCount == SIX_COUNT.getPrizeCount()) {
            lottoResultCount.addSixCount();
        }
    }
}
