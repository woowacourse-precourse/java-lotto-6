package lotto.dto;

import lotto.model.BonusNumber;
import lotto.model.LottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.Statistics;
import lotto.model.WinnerNumber;

public class BuyLottoDto {
    private PurchasePrice purchasePrice;
    private LottoNumbers lottoNumbers;
    private WinnerNumber winnerNumber;
    private BonusNumber bonusNumber;

    private BuyLottoDto(PurchasePrice purchasePrice, LottoNumbers lottoNumbers, WinnerNumber winnerNumber,
                        BonusNumber bonusNumber) {
        this.purchasePrice = purchasePrice;
        this.lottoNumbers = lottoNumbers;
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public static BuyLottoDto createBuyLottoDto(PurchasePrice purchasePrice,
                                                LottoNumbers lottoNumbers,
                                                WinnerNumber winnerNumber,
                                                BonusNumber bonusNumber) {
        return new BuyLottoDto(purchasePrice, lottoNumbers, winnerNumber, bonusNumber);
    }

    public PurchasePrice getPurchasePrice() {
        return purchasePrice;
    }

    public Statistics calculateMatching() {
        Statistics statistics = Statistics.createStatistics();
        statistics.calculateMatching(this.lottoNumbers, this.winnerNumber, this.bonusNumber);
        return statistics;
    }

}
