package lotto.service.impl;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinningLotto;
import lotto.service.JudgeService;
import lotto.vo.Result;

public class JudgeServiceImpl implements JudgeService {

    private boolean isThirdToFifthPlace(int winCount) {
        return winCount <= 5 && winCount >= 3;
    }

    private boolean isFirstPlace(int winCount) {
        return winCount == 6;
    }

    private boolean isSecondPlace(int winCount, boolean hasBonusNumber) {
        return winCount == 5 && hasBonusNumber;
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
            return winCount - 1;
        } else if (isThirdToFifthPlace(winCount)) {
            return winCount - 2;
        }
        return 0;
    }
}
