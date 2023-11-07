package lotto.constant;

public enum WinningResult {

    FIRST("1등: 6개 번호 일치 / 2,000,000,000원"),
    SECOND("2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원"),
    THIRD("3등: 5개 번호 일치 / 1,500,000원"),
    FORTH("4등: 4개 번호 일치 / 50,000원"),
    FIFTH("5등: 3개 번호 일치 / 5,000원");
    private final String winningMessage;
    WinningResult(String winningMessage){
        this.winningMessage = winningMessage;
    }

    public String getwinningMessage(){
        return winningMessage;
    }
}
