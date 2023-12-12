package lotto.controller;

public enum ViewMessage {
    InputUserMoney("구입금액을 입력해 주세요."),
    InputWinningNumbers("당첨 번호를 입력해 주세요."),
    InputBonusNumber("보너스 번호를 입력해 주세요."),
    OutputLottoTicketNumber("개를 구매했습니다."),
    OutputLottoResultThreeMatch("당첨 통계\n---\n3개 일치 (5,000원) - "),
    OutputLottoResultFourMatch("4개 일치 (50,000원) - "),
    OutputLottoResultFiveMatch("5개 일치 (1,500,000원) - "),
    OutputLottoResultBonusMatch("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OutputLottoResultSixMatch("6개 일치 (2,000,000,000원) - "),
    OutputLottoResultReturnRate("총 수익률은 "),
    ErrorInvaildMoney("[ERROR] 유효하지 않는 금액입니다."),
    ErrorInvaildWinningNumbers("[ERROR] 유효하지 않은 당첨 번호입니다."),
    ErrorInvaildBonusNumber("[ERROR]유효하지 않은 보너스 번호입니다.");

    public final String message;
    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public String getMessage(int count){
        return message + count +"개";
    }

    public String getMessage(double num){
        return message + num + "%입니다.";
    }
}
