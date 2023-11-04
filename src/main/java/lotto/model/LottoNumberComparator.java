package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberComparator {
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    private LottoNumberComparator(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoNumberComparator create(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return new LottoNumberComparator(winningLotto, bonusNumber);
    }

    public List<LottoMatch> calculateMatches(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .map(this::calculateMatchForSingleLotto)
                .collect(Collectors.toList());
    }

    private LottoMatch calculateMatchForSingleLotto(List<Integer> lottoNumbers) {
        long count = countMatchingNumbers(lottoNumbers);
        boolean hasBonusNumber = lottoNumbers.contains(bonusNumber.getBonusNumber());
        return LottoMatch.collect((int) count, hasBonusNumber);
    }

    private long countMatchingNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}