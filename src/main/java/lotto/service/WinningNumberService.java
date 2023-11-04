package lotto.service;

import static lotto.constant.LottoResult.*;

import java.util.List;
import java.util.function.Predicate;
import lotto.constant.message.InputMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResultCount;
import lotto.domain.LottoWinningNumber;
import lotto.util.ValidationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumberService {
    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();
    private final InputView inputView = new InputView();
    private final ValidationUtil validationUtil =new ValidationUtil();
    private final LottoResultCount lottoResultCount = new LottoResultCount();

    public void getInputWinningNumber(){
        String number = inputView.getInputWithMessage(InputMessage.INPUT_NUMBER.getMessage());
        List<Integer> winning = validationUtil.validateWinningNumber(number);
        String bonusNum = inputView.getInputWithMessage(InputMessage.INPUT_BONUS.getMessage());
        int bonus = validationUtil.validateWinningNumberWithBonus(bonusNum, winning);
        lottoWinningNumber.getWinningNumbersInfo(winning, bonus);
    }

    public void getLottoWinningResult(LottoPurchase lottoPurchase) {
        for (Lotto lotto: lottoPurchase.getLottos()) {
            List<Integer> LottoNums = lotto.getLottoNumbers();
            int matchCount = getMatchCount(LottoNums);
            addMatchCount(checkBonusNumber(LottoNums, matchCount));
        }
        ResultService resultService = new ResultService(lottoResultCount, lottoPurchase.getAmount());
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
            return matchCount * 10;
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
