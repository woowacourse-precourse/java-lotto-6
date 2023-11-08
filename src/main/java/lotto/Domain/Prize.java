package lotto.Domain;

import java.util.Arrays;
import java.util.function.BiPredicate;
public enum Prize {
    NOTHING(0
            , 0
            , (matchLotto, matchBonusNumber) -> matchLotto < 3),
    FIFTH(5000
            , 3
            , (matchLotto, matchBonusNumber) -> matchLotto == 3),
    FOURTH(50000
            , 4
            , (matchLotto, matchBonusNumber) -> matchLotto == 4),
    THIRD(1500000
            , 5
            , (matchLotto, matchBonusNumber) -> matchLotto == 5 && !matchBonusNumber),
    SECOND(30000000
            , 5
            , (matchLotto, matchBonusNumber) -> matchLotto == 5 && matchBonusNumber),
    FIRST(2000000000
            , 6
            , (matchLotto, matchBonusNumber) -> matchLotto == 6);

    private final int money;
    private final int matchLotto;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int money, final int matchLotto, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchLotto = matchLotto;
        this.isMatch = isMatch;
    }
    //생성된 로또 번호와 당첨 로또 번호 및 2등 보너스 번호, 랭킹 호출
    public static Prize getPrize(final int matchLotto, final boolean matchBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchLotto, matchBonusNumber))
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchLotto() {
        return matchLotto;
    }

}