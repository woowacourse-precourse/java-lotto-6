package lotto.model;
import java.util.function.BiPredicate;
import java.util.Arrays;
public enum LottoRank {
    NOLUCK("0원"
            , 0
            , 0
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber < 3; }),
    FIFTH("5,000원"
            , 5000
            , 3
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 3; }),
    FOURTH("50,000원"
            ,50000
            , 4
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 4; }),
    THIRD("1,500,000원"
            , 1500000
            , 5
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 5 & !containBonusNumber; }),
    SECOND("30,000,000원"
            ,30000000
            , 5
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 5 & containBonusNumber; }),
    FIRST("2,000,000,000원"
            ,2000000000
            , 6
            , (matchLottoNumber, containBonusNumber)
            -> { return matchLottoNumber == 6; });

    private final String winnigMoney;
    private final int winning;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> compare;

    LottoRank(final String winnigMoney,final int winning, final int matchLottoNumber, final BiPredicate<Integer, Boolean> compare) {
        this.winnigMoney = winnigMoney;
        this.winning = winning;
        this.matchLottoNumber = matchLottoNumber;
        this.compare = compare;
    }

    public String getWinnigMoney() {
        return winnigMoney;
    }

    public int getWinning(){
        return winning;
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
