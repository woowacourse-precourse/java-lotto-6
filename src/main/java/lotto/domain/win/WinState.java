package lotto.domain.win;

import java.util.Arrays;
import java.util.Optional;
import lotto.dto.LottoNumberMatchDTO;
import lotto.dto.WinningStatisticDTO;

public enum WinState {

    FIFTH_PLACE("3개 일치", 3, TriBoolean.WHATEVER, 5000),
    FOURTH_PLACE("4개 일치", 4, TriBoolean.WHATEVER, 50000),
    THIRD_PLACE("5개 일치", 5, TriBoolean.FALSE, 1500000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", 5, TriBoolean.TRUE, 30000000),
    FIRST_PLACE("6개 일치", 6, TriBoolean.FALSE, 2000000000);

    private final String description;
    private final int includedNumbersCount;
    private final TriBoolean isRequireBonusNumberState;
    private final int prize;

    WinState(String description, int includedNumbersCount, TriBoolean isRequireBonusNumberState, int prize) {
        this.description = description;
        this.includedNumbersCount = includedNumbersCount;
        this.isRequireBonusNumberState = isRequireBonusNumberState;
        this.prize = prize;
    }

    public static Optional<WinState> from(LottoNumberMatchDTO lottoNumberMatchDTO) {
        int includedNumbersCount = lottoNumberMatchDTO.includedNumberCount();
        TriBoolean isIncludedBonusNumber = TriBoolean.from(lottoNumberMatchDTO.isIncludedBonusNumber());

        return Arrays.stream(values())
                .filter(winState -> winState.equals(includedNumbersCount, isIncludedBonusNumber))
                .findFirst();
    }

    public WinningStatisticDTO getWinStateInformation(int winningCount) {
        return new WinningStatisticDTO(description, prize, winningCount);
    }

    private boolean equals(int includedNumbersCount, TriBoolean isIncludedBonusNumber) {
        boolean equalsIncludedNumbersCount = this.includedNumbersCount == includedNumbersCount;
        boolean equalsRequireBonusNumber = isRequireBonusNumberState.equals(isIncludedBonusNumber);
        return equalsIncludedNumbersCount && equalsRequireBonusNumber;
    }

}
