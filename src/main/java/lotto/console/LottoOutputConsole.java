package lotto.console;

import java.util.List;
import lotto.LottoRanking;
import lotto.SoldLotto;

public class LottoOutputConsole {
    private static final String MESSAGE_FOOTER_BUY_LOTTO = "개를 구매했습니다.";
    private static final String MESSAGE_HEADER_LOTTO_RESULTS = """
            
            당첨 통계
            ---""";
    private static final String MESSAGE_HEADER_RETURN_RATE = "총 수익률은 ";
    private static final String MESSAGE_FOOTER_RETURN_RATE = "%입니다.";

    public void printSoldLotto(SoldLotto soldLotto) {
        System.out.println(System.lineSeparator() + soldLotto.getSoldLottoTicketsCount() + MESSAGE_FOOTER_BUY_LOTTO);
        System.out.println(soldLotto);
    }

    public void printLottoResults(List<LottoRanking> lottoRankings, double returnRate) {
        System.out.println(MESSAGE_HEADER_LOTTO_RESULTS);
        String resultsMessageBody = LottoRanking.rankingsToString(lottoRankings);
        System.out.print(resultsMessageBody);
        System.out.println(MESSAGE_HEADER_RETURN_RATE + returnRate + MESSAGE_FOOTER_RETURN_RATE);
    }
}
