package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberComparator {
    private final WinningLotto winningLotto;

    private LottoNumberComparator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static LottoNumberComparator init(WinningLotto winningLotto) {
        return new LottoNumberComparator(winningLotto);
    }

    public List<LottoMatch> calculateMatches(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .map(this::calculateMatchForSingleLotto)
                .collect(Collectors.toList());
    }

    private LottoMatch calculateMatchForSingleLotto(List<Integer> lottoNumbers) {
        long count = countMatchingNumbers(lottoNumbers);
        boolean hasBonusNumber = lottoNumbers.contains(winningLotto.getBonusNumber());
        return LottoMatch.collect((int) count, hasBonusNumber);
    }

    private long countMatchingNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .filter(winningLotto.getWinningLotto().getNumbers()::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberComparator lottoNumberComparator = (LottoNumberComparator) o;
        return winningLotto == lottoNumberComparator.winningLotto;
    }
}