package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.exception.BonusNumberDuplicationException;
import lotto.exception.WinningLottoNumbersDuplicationException;
import lotto.exception.WrongLottoLengthException;

public class WinningLotto {

    private static final int LENGTH = 6;

    List<LottoNumber> winningLotto;
    LottoNumber bonusNumber;

    public WinningLotto(List<String> winningLottoNumbers, String bonusNumber) {

        checkDuplication(winningLottoNumbers);
        checkDuplicationFrom(winningLottoNumbers, bonusNumber);
        checkLength( winningLottoNumbers);
        winningLotto = winningLottoNumbers.stream()
                                          .map(Integer::parseInt)
                                          .map(number -> LottoNumber.of(number))
                                          .toList();
        this.bonusNumber = LottoNumber.of(Integer.parseInt(bonusNumber));

    }

    public Rank calculateRankWith(Lotto lotto) {

        int count = (int) lotto.stream()
                               .filter(number -> winningLotto.contains(number))
                               .count();

        boolean isBonusNumber = lotto.contains(bonusNumber);

        return Arrays.stream(Rank.values())
                     .filter(rank -> rank.matchRank(count, isBonusNumber))
                     .findFirst()
                     .orElse(Rank.NONE);
    }

    public WinningStatistics calculateStaticsFrom(List<Lotto> lottos) {
        List<Rank> ranks = lottos.stream()
                                 .map(this::calculateRankWith)
                                 .toList();
        return WinningStatistics.from(ranks);
    }

    private void checkDuplication(List<String> winningLotto) {
        List<String> distinctList = winningLotto.stream()
                                             .distinct()
                                             .toList();
        if (distinctList.size() != winningLotto.size()) {
            throw new WinningLottoNumbersDuplicationException();
        }
    }

    private void checkDuplicationFrom(List<String> winningLotto, String bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new BonusNumberDuplicationException();
        }
    }
    private void checkLength(List<String> lottoNumbers) {
        if (lottoNumbers.size() != LENGTH) {
            throw new WrongLottoLengthException();
        }
    }

}
