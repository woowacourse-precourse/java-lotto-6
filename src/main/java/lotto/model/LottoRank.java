package lotto.model;
import java.util.function.BiPredicate;
import java.util.Arrays;
public enum LottoRank {
    NOLUCK("0"
            , 0
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber < 3; }),
    FIFTH("5,000"
            , 3
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 3; }),
    FOURTH("50,000원"
            , 4
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 4; }),
    THIRD("1,500,000원"
            , 5
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 5 & !containBonusNumber; }),
    SECOND("30,000,000원"
            , 5
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 5 & containBonusNumber; }),
    FIRST("2,000,000,000원"
            , 6
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 6; });

    private final String winnigMoney;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> compare;

    LottoRank(final String winnigMoney, final int matchLottoNumber, final BiPredicate<Integer, Boolean> compare) {
        this.winnigMoney = winnigMoney;
        this.matchLottoNumber = matchLottoNumber;
        this.compare = compare;
    }

    public String getWinnigMoney() {
        return winnigMoney;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }

    public static LottoRank getRank(int matchLottoNumber, boolean containBonusNumber){
        return Arrays.stream(LottoRank.values())
                .filter((rankStandard)
                        -> { return rankStandard.compare.test(matchLottoNumber,containBonusNumber); })
                .findAny()
                .orElse(NOLUCK);
    }

}
