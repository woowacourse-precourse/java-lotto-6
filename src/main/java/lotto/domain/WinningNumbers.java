package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.util.ErrorMessage;

public class WinningNumbers extends Lotto {

    private BonusNumber bonusNumber;

    public WinningNumbers(String winningNumbers) {
        super(convertStringToList(winningNumbers));
    }

    private static List<Integer> convertStringToList(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_WINNING_NUMBER.getMessage());
        }
    }

    @Override
    protected String getNumbersCountErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_COUNT.getMessage();
    }

    @Override
    protected String getNumbersInRangeErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_IN_RANGE.getMessage();
    }

    @Override
    protected String getDuplicatedNumberErrorMessage() {
        return ErrorMessage.WINNING_NUMBER_UNIQUE.getMessage();
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        validateDuplicatedBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedBonusNumber(BonusNumber bonusNumber) {
        if (this.containsNumber(bonusNumber.number())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_UNIQUE.getMessage());
        }
    }

    private void validateBonusNumberInitialized() {
        if (bonusNumber == null) {
            throw new IllegalStateException(ErrorMessage.BONUS_NUMBER_NOT_SET.getMessage());
        }
    }

    public LottoPrizeBreakdown createLottoPrizeBreakdown(List<Lotto> lottoTickets) {
        Map<LottoRank, Integer> prizeDetails = initPrizeDetails();
        for (Lotto lotto : lottoTickets) {
            int matchCount = getWinningNumberMatchCount(lotto);
            boolean matchBonus = isMatchBonus(lotto);
            updatePrizeDetail(matchCount, matchBonus, prizeDetails);
        }

        return new LottoPrizeBreakdown(prizeDetails);
    }

    private Map<LottoRank, Integer> initPrizeDetails() {
        return Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(Function.identity(), rank -> 0));
    }

    private void updatePrizeDetail(int matchCount, boolean matchBonus, Map<LottoRank, Integer> prizeDetails) {
        LottoRank.find(matchCount, matchBonus)
                .ifPresent(rank -> prizeDetails.merge(rank, 1, Integer::sum));
    }

    private boolean isMatchBonus(Lotto lotto) {
        validateBonusNumberInitialized();
        return lotto.containsNumber(bonusNumber.number());
    }

    private int getWinningNumberMatchCount(Lotto lotto) {
        return (int) getNumbers().stream()
                .filter(lotto::containsNumber)
                .count();
    }
}
