package lotto.enums;

public enum SystemErrorMessages {
    TICKETS_WAS_NOT_CREATED("어떠한 LottoTicket 도 없습니다. LottoTicket 생성해주세요. LottoPurchase 의 generateLottoTickets (로또 생성) 후 호출 될 수 있습니다."),
    RESULT_WAS_NOT_CREATED("어떠한 WinningResult 도 없습니다. WinningResult 를 생성해주세요."),
    TOTAL_WINNING_WAS_NOT_CREATED("어떠한 TotalWinning 도 없습니다. TotalWinning 를 생성해주세요.");

    private final String message;

    SystemErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
