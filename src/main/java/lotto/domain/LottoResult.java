package lotto.domain;

import lotto.dto.LottoResultDTO;
import lotto.dto.LottoReturnsRateDTO;
import lotto.dto.LottoWinningResultDTO;

import java.util.List;

import static lotto.constants.DomainConstants.LOTTO_MIN_WINNING_NUMBER_MATCH_COUNT;
import static lotto.constants.DomainConstants.ONE_LOTTO_PURCHASE_AMOUNT;
import static lotto.constants.DomainConstants.PERCENT;
import static lotto.exception.LottoException.BONUS_NUMBER_CAN_NOT_CONTAIN_WINNING_LOTTO;

public class LottoResult {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private double totalWinningAmount;

    private LottoResult(final Lotto winnnigLotto, final BonusNumber bonusNumber) {
        this.winningLotto = winnnigLotto;
        this.bonusNumber = bonusNumber;
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
        List<LottoWinningResultDTO> lottoWinningResultDTOs = lottos.stream()
                .map(this::calculateWinningResult)
                .toList();
        LottoReturnsRateDTO lottoReturnsRateDTO = calculateReturnsRate(lottos.size());
        return new LottoResultDTO(lottoWinningResultDTOs, lottoReturnsRateDTO);
    }

    private LottoWinningResultDTO calculateWinningResult(final Lotto lotto) {
        int numberMatchCount = calculateNumberMatchCount(lotto);
        boolean isBonusNumberMatch = isBonusNumberMatch(lotto);
        updateTotalWinningAmount(numberMatchCount, isBonusNumberMatch);
        return new LottoWinningResultDTO(numberMatchCount, isBonusNumberMatch);
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
        if (isNotWinning(numberMatchCount)) {
            return;
        }
        totalWinningAmount += LottoWinningAmount.of(numberMatchCount, isBonusNumberMatch).getValue();
    }

    private boolean isNotWinning(final int numberMatchCount) {
        return numberMatchCount < LOTTO_MIN_WINNING_NUMBER_MATCH_COUNT.getValue();
    }

    private LottoReturnsRateDTO calculateReturnsRate(final int lottoCount) {
        double totalReturnsRate = totalWinningAmount / (lottoCount * ONE_LOTTO_PURCHASE_AMOUNT.getValue()) * PERCENT.getValue();
        return new LottoReturnsRateDTO(totalReturnsRate);
    }
}
