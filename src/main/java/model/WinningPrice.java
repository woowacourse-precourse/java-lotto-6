package model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum WinningPrice {
    CORRECT_ZERO(0
            , 0
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
    CORRECT_THREE(5_000
            , 3
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    CORRECT_FOUR(50_000
            , 4
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    CORRECT_FIVE(1_500_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    CORRECT_FIVE_BONUS(30_000_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    CORRECT_ALL(2_000_000_000
            , 6
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

    private final int winningPrice;
    private final int correctLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    WinningPrice(final int money, final int correctLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.winningPrice = money;
        this.correctLottoNumber = correctLottoNumber;
        this.isMatch = isMatch;
    }

    public static WinningPrice getWinningPrice(final int correctLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(WinningPrice.values())
                .filter(winningPrice -> winningPrice.isMatch.test(correctLottoNumber, containBonusNumber))
                .findAny()
                .orElse(CORRECT_ZERO);
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCorrectLottoNumber() {
        return correctLottoNumber;
    }
}