package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public enum Prize {
    LAST_PLACE(0, 0, (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
    FIFTH_PLACE(5_000, 3, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    FOURTH_PLACE(50_000, 4, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    THIRD_PLACE(1_500_000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    SECOND_PLACE(30_000_000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    FIRST_PLACE(2_000_000_000, 6, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

    private final int money;
    private final int matchNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(int money, int matchNumber, BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchNumber = matchNumber;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchNumber, final boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchNumber, containBonusNumber))
                .findAny()
                .orElse(LAST_PLACE);
    }

    public static List<Prize> getWinning() {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize != LAST_PLACE)
                .collect(Collectors.toList());
    }

    public int getMoney() {
        return money;
    }

    public int getMatchLottoNumber() {
        return matchNumber;
    }
}