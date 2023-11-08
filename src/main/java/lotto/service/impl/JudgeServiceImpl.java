package lotto.service.impl;

import static lotto.utils.LottoConstants.ALL_WINS;
import static lotto.utils.LottoConstants.FIVE_WINS;
import static lotto.utils.LottoConstants.NO_WIN;
import static lotto.utils.LottoConstants.THREE_WINS;
import static lotto.utils.CalculationConstants.MINUS_ONE;
import static lotto.utils.CalculationConstants.MINUS_TWO;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.vo.Wallet;
import lotto.domain.WinningLotto;
import lotto.service.JudgeService;
import lotto.vo.Result;

public class JudgeServiceImpl implements JudgeService {

    private boolean isThirdToFifthPlace(int winCount) {
        return winCount <= FIVE_WINS.getValue() && winCount >= THREE_WINS.getValue();
    }

    private boolean isFirstPlace(int winCount) {
        return winCount == ALL_WINS.getValue();
    }

    private boolean isSecondPlace(int winCount, boolean hasBonusNumber) {
        return winCount == FIVE_WINS.getValue() && hasBonusNumber;
    }

    @Override
    public List<Result> compareLottoBundleAndWinnerNumbers(Wallet wallet, WinningLotto winnerNumbers) {
        List<Lotto> lottoBundle = wallet.getLottoBundle();
        List<Integer> winner = winnerNumbers.getWinnerNumbers();
        Integer bonusNumber = winnerNumbers.getBonusNumber();
        return lottoBundle.stream()
                .map(lotto -> makeResult(winner, bonusNumber, lotto))
                .toList();
    }

    private Result makeResult(List<Integer> winner, Integer bonusNumber, Lotto lotto) {
        boolean hasBonusNumber = isBonusNumberInLotto(bonusNumber, lotto);
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        int winCount = calcNumberOfWinningNumbers(winner, lottoNumbers);
        int rank = calcRank(winCount, hasBonusNumber);
        return new Result(rank);
    }

    private boolean isBonusNumberInLotto(Integer bonusNumber, Lotto lotto) {
        return lotto.isContainBonusNumber(bonusNumber);
    }

    private int calcNumberOfWinningNumbers(List<Integer> winner, List<Integer> lottoNumbers) {
        List<Integer> comparisonLottoAndWinner = new ArrayList<>(lottoNumbers);
        comparisonLottoAndWinner.retainAll(winner);
        return comparisonLottoAndWinner.size();
    }

    private int calcRank(int winCount, boolean hasBonusNumber) {
        if (isFirstPlace(winCount) || isSecondPlace(winCount, hasBonusNumber)) {
            return winCount - MINUS_ONE.getValue();
        } else if (isThirdToFifthPlace(winCount)) {
            return winCount - MINUS_TWO.getValue();
        }

        return NO_WIN.getValue();
    }
}
