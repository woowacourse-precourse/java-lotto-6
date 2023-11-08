package model;

import java.util.function.BiPredicate;

public enum WinningPrice {
    CORRECT_ZERO(0
            , 0
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber < 3),
    CORRECT_THREE(5_000
            , 3
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber == 3),
    CORRECT_FOUR(50_000
            , 4
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber == 4),
    CORRECT_FIVE(1_500_000
            , 5
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber == 5 && !containBonusNumber),
    CORRECT_FIVE_BONUS(30_000_000
            , 5
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber == 5 && containBonusNumber),
    CORRECT_ALL(2_000_000_000
            , 6
            , (correctLottoNumber, containBonusNumber) -> correctLottoNumber == 6);

    private final int winningPrice;
    private final int correctLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    WinningPrice(final int price, final int correctLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.winningPrice = price;
        this.correctLottoNumber = correctLottoNumber;
        this.isMatch = isMatch;
    }

    public static WinningPrice winningPrice(final int correctLottoNumber, final boolean containBonusNumber) {
        for (WinningPrice winningPrice : WinningPrice.values()) {
            if (winningPrice.isMatch.test(correctLottoNumber, containBonusNumber)) {
                return winningPrice;
            }
        }
        return CORRECT_ZERO;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getCorrectLottoNumber() {
        return correctLottoNumber;
    }
}