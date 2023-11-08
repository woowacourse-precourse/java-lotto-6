package lotto.domain;

import lotto.dto.LottoResultDTO;
import lotto.dto.LottoReturnsRateDTO;
import lotto.dto.LottoWinningResultDTO;

import java.util.List;

import static lotto.constants.DomainConstants.*;
import static lotto.exception.LottoException.BONUS_NUMBER_CAN_NOT_CONTAIN_WINNING_LOTTO;

public class LottoResult {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private Rank lottoRank;
    private double totalWinningAmount;

    private LottoResult(final Lotto winnnigLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winnnigLotto;
        this.bonusNumber = bonusNumber;
        this.lottoRank = Rank.create();
        validate();
    }

    private void validate() {
        if (isWinningLottoContainBonusNumber()) {
            BONUS_NUMBER_CAN_NOT_CONTAIN_WINNING_LOTTO.create();
        }
    }

    private boolean isWinningLottoContainBonusNumber() {
        return winningLotto.contains(bonusNumber.getNumber());
    }

    public static LottoResult create(final Lotto winningLotto, final BonusNumber bonusNumber) {
        return new LottoResult(winningLotto, bonusNumber);
    }

    public LottoResultDTO calculateResult(final List<Lotto> lottos) {
        lottos.forEach(this::calculateWinningResult);
        LottoWinningResultDTO lottoWinningResultDTO = lottoRank.toDTO();
        LottoReturnsRateDTO lottoReturnsRateDTO = calculateReturnsRate(lottos.size());
        return new LottoResultDTO(lottoWinningResultDTO, lottoReturnsRateDTO);
    }

    private void calculateWinningResult(final Lotto lotto) {
        int numberMatchCount = calculateNumberMatchCount(lotto);
        boolean isBonusNumberMatch = isBonusNumberMatch(lotto);
        updateTotalWinningAmount(numberMatchCount, isBonusNumberMatch);
        updateWinningResult(numberMatchCount, isBonusNumberMatch);
    }

    private int calculateNumberMatchCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean isBonusNumberMatch(final Lotto lotto) {
        return lotto.contains(bonusNumber.getNumber());
    }

    private void updateTotalWinningAmount(final int numberMatchCount, final boolean isBonusNumberMatch) {
        totalWinningAmount += LottoWinningAmount.of(numberMatchCount, isBonusNumberMatch).getValue();
    }

    private void updateWinningResult(final int numberMatchCount, final boolean isBonusNumberMatch) {
        lottoRank.updateRank(numberMatchCount, isBonusNumberMatch);
    }

    private LottoReturnsRateDTO calculateReturnsRate(final int lottoCount) {
        double totalReturnsRate = totalWinningAmount / (lottoCount * ONE_LOTTO_PURCHASE_AMOUNT.getValue()) * PERCENT.getValue();
        return new LottoReturnsRateDTO(totalReturnsRate);
    }
}
