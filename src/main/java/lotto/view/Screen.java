package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.winninglotto.LottoWinningResult;

public class Screen {

    private static final String LOTTO_COUNT_MESSAGE = """
            
        %d개를 구매했습니다.
        """;

    private static final String LOTTO_RESULT_MESSAGE = """
                
        당첨 통계
        ---
        """;

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottoTicket(int lottoCount, LottoTicket lottoTicket) {
        String lottoNumbers = LottoTicketStringBuilder.build(lottoTicket);
        String lottoPurchaseMessage = new StringBuilder()
            .append(LOTTO_COUNT_MESSAGE.formatted(lottoCount))
            .append(lottoNumbers)
            .toString();
        System.out.println(lottoPurchaseMessage);
    }

    public void printLottoResult(LottoWinningResult lottoWinningResult, double profitRate) {
        String lottoResult = LottoResultStringBuilder.build(lottoWinningResult.getLottoResult());
        String lottoResultMessage = new StringBuilder(LOTTO_RESULT_MESSAGE)
            .append(lottoResult)
            .append("\n")
            .append(PROFIT_RATE_MESSAGE.formatted(profitRate))
            .toString();
        System.out.println(lottoResultMessage);
    }
}
