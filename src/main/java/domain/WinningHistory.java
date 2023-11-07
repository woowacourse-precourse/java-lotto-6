package domain;

/**
 * packageName    : domain
 * fileName       : WinningHistory
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public enum WinningHistory {

    FIFTH(3, 5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6, 2000000000);

    private final int matchNumbers;
    private final int prizeMoney;
    WinningHistory(int matchNumbers, int prizeMoney){
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static WinningHistory getWinningHistoryType(int matchNumbers, boolean isMatchBonusNumber) {
        for (WinningHistory rank : values()) {
            if (rank.matches(matchNumbers, isMatchBonusNumber)) {
                return rank;
            }
        }
        return null;
    }


    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static WinningHistory calculateRank(int matchNumbers, boolean isMatchBonusNumber) {
        for (WinningHistory rank : values()) {
            if (rank.matches(matchNumbers, isMatchBonusNumber)) {
                return rank;
            }
        }
        return null;
    }

    private boolean matches(int matchNumbers, boolean isMatchBonusNumber) {
        if (this == SECOND) {
            return checkSecond(matchNumbers, isMatchBonusNumber);
        }
        return checkRemaining(matchNumbers, isMatchBonusNumber);
    }

    private boolean checkSecond(int matchNumbers, boolean isMatchBonusNumber){
        return getMatchNumbers() == matchNumbers && isMatchBonusNumber;
    }

    private boolean checkRemaining(int matchNumbers, boolean isMatchBonusNumber){
        return getMatchNumbers() == matchNumbers && !isMatchBonusNumber;
    }
}
