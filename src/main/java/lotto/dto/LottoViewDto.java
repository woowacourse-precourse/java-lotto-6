package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;

import java.util.List;

public class LottoViewDto {
    private static final int LOTTO_PRICE = 1_000;
    private Integer purchaseAmount;
    private Integer purchaseAmountCount;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private List<LottoMatch> lottoMatches;

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public Integer getPurchaseAmountCount() {
        return purchaseAmountCount;
    }

    public void setPurchaseAmountAndCount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseAmountCount = purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<LottoMatch> getLottoMatches() {
        return lottoMatches;
    }

    public void setLottoMatches(List<LottoMatch> lottoMatches) {
        this.lottoMatches = lottoMatches;
    }

    public boolean isPurchaseAmount() {
        return purchaseAmount != null;
    }

    public boolean isLottos() {
        return lottos != null;
    }

    public boolean isWinningNumbers() {
        return winningNumbers != null;
    }

    public boolean isBonusNumber() {
        return bonusNumber != null;
    }
}
