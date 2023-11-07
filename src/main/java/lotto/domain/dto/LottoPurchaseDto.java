package lotto.domain.dto;

import java.util.List;
import lotto.domain.LottoList;
import lotto.domain.Money;

public class LottoPurchaseDto {
    private final LottoList lottoList;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private LottoPurchaseDto(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoPurchaseDto Of(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoPurchaseDto(lottoList, winningNumbers, bonusNumber);
    }

    public int getCost() {
        return lottoList.size() * Money.EACH_LOTTO;
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
