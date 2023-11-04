package lotto.domain;

public enum Winner {

    //    1등: 6개 번호 일치 / 2,000,000,000원
    FRIST(6, false, 2000000000),
    //    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    SECOND(5, true, 30000000),
    //    3등: 5개 번호 일치 / 1,500,000원
    THIRD(5, false, 1500000),
    //    4등: 4개 번호 일치 / 50,000원
    FOURTH(4, false, 50000),
    //    5등: 3개 번호 일치 / 5,000원
    FIFTH(3, false, 5000);

    private int sameCount;
    private boolean isSameBonusNumber;
    private int winningMoney;

    Winner(int sameCount, boolean isSameBonusNumber, int winningMoney) {
        this.sameCount = sameCount;
        this.isSameBonusNumber = isSameBonusNumber;
        this.winningMoney = winningMoney;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isSameBonusNumber() {
        return isSameBonusNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
