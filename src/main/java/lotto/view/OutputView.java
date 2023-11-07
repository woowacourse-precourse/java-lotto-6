package lotto.view;

import java.util.Arrays;
import lotto.constants.LottoReward;
import lotto.domain.TicketCount;
import lotto.domain.Lottos;
import lotto.dto.ReturnsRateDto;
import lotto.dto.WinningResultDto;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void displayLottoCount(TicketCount TicketCount) {
        System.out.printf(Message.LOTTO_COUNT.getMessage() + System.lineSeparator(), TicketCount.getTicketCount());
    }

    public void displayLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public void displayResultTop() {
        System.out.println(Message.RESULT.getMessage());
    }

    public void displayWinningStatics(WinningResultDto winningResultDto) {
        Arrays.stream(LottoReward.values())
                .filter(lottoReward -> !lottoReward.equals(LottoReward.NOTHING))
                .forEach(lottoReward -> System.out.println(getPrintWinningResult(lottoReward, winningResultDto)));
    }

    public void displayReturnsRate(ReturnsRateDto returnsRateDto) {
        System.out.printf(Message.LOTTO_ALL_RETURNS_RATE.getMessage(), returnsRateDto.returnsRate());
    }

    public void displayErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private String getPrintWinningResult(LottoReward lottoReward, WinningResultDto winningResultDto) {
        if (lottoReward == LottoReward.SECOND) {
            return String.format(Message.LOTTO_SECOND_RESULT.getMessage(),
                    lottoReward.getMatchLottoCount(),
                    lottoReward.getWinningAmount(),
                    winningResultDto.getWinningCount(lottoReward));
        }

        return String.format(Message.LOTTO_RESULT.getMessage(),
                lottoReward.getMatchLottoCount(),
                lottoReward.getWinningAmount(),
                winningResultDto.getWinningCount(lottoReward));
    }

    enum Message {
        LOTTO_COUNT("%d개를 구매했습니다."),
        RESULT("당첨 통계\n---"),
        LOTTO_RESULT("%d개 일치 (%s원) - %d개"),
        LOTTO_SECOND_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
        LOTTO_ALL_RETURNS_RATE("총 수익률은 %.1f%%입니다.");

        private String message;

        Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
