package lotto;

public enum Notification {

    start("구입 금액을 입력해 주세요."),
    buy("개를 구매했습니다."),
    inputWinning("당첨 번호를 입력해 주세요."),
    inputBonus("보너스 번호를 입력해 주세요."),
    result("당첨 통계\n---"),
    fifthPlace("3개 일치 (5,000원) - "),
    fourthPlace("4개 일치 (50,000원) - "),
    thirdPlace("5개 일치 (1,500,000원) - "),
    secondPlace("5개 일치, 보너스 불 일치 (30,000,000원) - "),
    firstPlace("6개 일치 (2,000,000,000원) - ");

    private String message;

    private Notification (String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

