package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberComparator {
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<LottoMatch> calculateMatches(List<Lotto> lottoList) {
        return lottoList.stream()
                .map(Lotto::getNumbers)
                .map(lottoNumbers -> {
                    long count = lottoNumbers.stream()
                            .filter(winningLotto.getNumbers()::contains)
                            .count();
                    boolean hasBonusNumber = lottoNumbers.contains(bonusNumber.getBonusNumber());
                    return LottoMatch.collect((int) count, hasBonusNumber);
                })
                .collect(Collectors.toList());
    }
}