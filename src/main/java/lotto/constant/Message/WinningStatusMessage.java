package lotto.constant.Message;

import lotto.constant.LottoNumber;
import lotto.constant.Sign;
import lotto.util.StringUtil;

public enum WinningStatusMessage {
    WINNING_STATUS_MESSAGE("당첨 통계"),
    FIRST_PRIZE_STATUS_MESSAGE(LottoNumber.NUMBER_NEEDED_FOR_FIRST + "개 일치 (%s원)" + Sign.SEPARATOR + "%d개"),
    SECOND_PRIZE_STATUS_MESSAGE(LottoNumber.NUMBER_NEEDED_FOR_SECOND + "개 일치, 보너스 볼 일치 (%s원)" + Sign.SEPARATOR + "%d개"),
    THIRD_PRIZE_STATUS_MESSAGE(LottoNumber.NUMBER_NEEDED_FOR_THIRD + "개 일치 (%s원)" + Sign.SEPARATOR + "%d개"),
    FOURTH_PRIZE_STATUS_MESSAGE(LottoNumber.NUMBER_NEEDED_FOR_FOURTH + "개 일치 (%s원)" + Sign.SEPARATOR + "%d개"),
    FIFTH_PRIZE_STATUS_MESSAGE(LottoNumber.NUMBER_NEEDED_FOR_FIFTH + "개 일치 (%s원)" + Sign.SEPARATOR + "%d개"),
    TOTAL_RETURN_MESSAGE("총 수익률은 %s" + Sign.PERCENT + "입니다.");

    private final String winningStatusMessage;

    WinningStatusMessage(String winningStatusMessage) {
        this.winningStatusMessage = winningStatusMessage;
    }

    public String getWinningStatusMessage() {
        return winningStatusMessage;
    }

}
