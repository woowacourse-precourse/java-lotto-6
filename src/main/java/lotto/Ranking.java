package lotto;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {
    SIXTH(0, 0, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber < 3),
    FIFTH(5000, 3, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber == 3),
    FOURTH(50000, 4, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber == 4),
    THIRD(1500000, 5, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber == 5 && !checkBonusNumber),
    SECOND(30000000, 5, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber == 5 && checkBonusNumber),
    FIRST(2000000000, 6, (matchLottoNumber, checkBonusNumber) -> matchLottoNumber == 6);

    private final int money;
    private final int checkLottoNumber;
    private final BiPredicate<Integer, Boolean> checkMatch;

    Ranking(final int money, final int checkLottoNumber, final BiPredicate<Integer, Boolean> checkMatch) {
        this.money = money;
        this.checkLottoNumber = checkLottoNumber;
        this.checkMatch = checkMatch;
    }

    public static Ranking getRanking(final int checkLottoNumber, final boolean checkBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.checkMatch.test(checkLottoNumber, checkBonusNumber))
                .findAny()
                .orElse(SIXTH);
    }

    public int getMoney() {
        return money;
    }

    public int getCheckLottoNumber() {
        return checkLottoNumber;
    }
}
