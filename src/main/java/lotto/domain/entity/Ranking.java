package lotto.domain.entity;

import java.util.Arrays;

//EnumMapperFactory 도 생각해보기.  //Ranking
public enum Ranking { //3등이면서 동시에 4등인 경우는 없다. 등수를 계산하는 역할을 할 수 있음.
    //상금도 VO화하기

    //enum은 "정해진 상수값"을 쓸때 쓰는거임. 여기에 "공통된 부분을 묶어서 중복제거"에 탁월함.
    //Prize를 abstract class대신 enum을 둠을 통해 얻는장점? first second .. 다 객체로 두려면 중복코드가 너무 많아짐
    //getter도 줄여줄수있고, WinningLotto랑 Money의 연관성 강화
    //MoneyEnum에는 2,000,000,000원  200000000 등 같은 값이지만 다르게 출력될수있는 값 관리
    FIRST(6, false, 2000000000), //★한번만 호출되기에 same ThousandUnitMoney Object됨!
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    No(0, false, 0);

    private final int matchCount;
    private final boolean isUsingBonusNumber;
    private final int prizeAmount;

    Ranking(int matchCount, boolean isUsingBonusNumber, int prizeAmount) {
        this.matchCount = matchCount;
        this.isUsingBonusNumber = isUsingBonusNumber;
        this.prizeAmount = prizeAmount;
    }

    public static Ranking calcWinningMoney(int matchCount, boolean isMatchingBonus) {
        return Arrays.stream(Ranking.values())
                .filter(prize
                        -> prize.isSameMatchCount(matchCount)
                        && !prize.isUsingBonusNumberAndNotMathed(isMatchingBonus))
                .findAny()
                .orElse(No);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isUsingBonusNumber() {
        return isUsingBonusNumber;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean isUsingBonusNumberAndNotMathed(boolean isMatchingBonus) {
        if (isUsingBonusNumber == true && isMatchingBonus == false) {
            return true;
        }
        return false;
    }
}
