package lotto.view;

import lotto.dto.RankingDto;
import lotto.dto.WinningResultDto;

import java.text.DecimalFormat;

public class OutputMessage {

    private OutputMessage() {
    }

    private static class OutputMessageHolder {
        private static OutputMessage outputMessage = new OutputMessage();
    }

    public static OutputMessage getInstance() {
        return OutputMessageHolder.outputMessage;
    }

    private static String USER_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_START_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_RANKING_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";
    private static DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public static String getUserLottoCountMessage(int size) {
        return String.format(USER_LOTTO_COUNT_MESSAGE, size);
    }

    public static String getWinningResultStartMessage() {
        return WINNING_RESULT_START_MESSAGE;
    }

    public static String getWinningResultMessage(RankingDto rankingDto) {
        if (rankingDto.getRankingNumber().equals("SECOND")) {
            return String.format(SECOND_RANKING_RESULT_MESSAGE, rankingDto.getMatchCount(), decimalFormat.format(rankingDto.getReward()), rankingDto.getCount());
        }

        return String.format(WINNING_RESULT_MESSAGE, rankingDto.getMatchCount(), decimalFormat.format(rankingDto.getReward()), rankingDto.getCount());
    }

    public static String getRateOfReturnMessage(WinningResultDto winningResultDto) {
        String returnRate = String.format("%,.1f", winningResultDto.getReturnRate());
        return String.format(RATE_OF_RETURN_MESSAGE, returnRate);
    }
}
