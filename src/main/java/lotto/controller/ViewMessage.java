package lotto.controller;

public enum ViewMessage {
    InputUserMoney("구입금액을 입력해 주세요."),
    InputWinningNumbers("당첨 번호를 입력해 주세요."),
    OutputLottoTicketNumber("개를 구매했습니다."),
    ErrorInvaildMoney("[ERROR] 유효하지 않는 금액입니다."),
    ErrorInvaildWinningNumbers("[ERROR] 유효하지 않은 당첨 번호입니다.");

    public final String message;
    ViewMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
