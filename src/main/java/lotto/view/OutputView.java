package lotto.view;

import lotto.constant.response.Information;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String START_SEPARATOR = "[";
    private static final String MIDDLE_SEPARATOR = ", ";
    private static final String END_SEPARATOR = "]";
    private static final String LINE_SEPARATOR = "---";

    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void printLottoTicket(List<Lotto> lottoTicket) {
        System.out.printf((Information.NUMBER_PURCHASED.getMessage()) + "%n", lottoTicket.size());
        for (Lotto lotto : lottoTicket) {
            System.out.println(printLottoDetail(lotto));
        }
    }

    private String printLottoDetail(Lotto lotto) {
        String lottoDetail = START_SEPARATOR;
        lottoDetail += String.join(MIDDLE_SEPARATOR, lotto.getLottoNumbers().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .toList());
        lottoDetail += END_SEPARATOR;
        return lottoDetail;
    }

    public void printWinningDetails(Map<Rank, Integer> winningDetails) {
        System.out.println(Information.WINNING_STATISTICS.getMessage() + System.lineSeparator() + LINE_SEPARATOR);
        for (Rank rank : Rank.winningValues()) {
            System.out.printf((rank.getMessage()) + "%n", winningDetails.get(rank));
        }
    }

    public void printProfitRate(String profitRate) {
        System.out.printf((Information.PROFIT_RATE.getMessage()) + "%n", profitRate);
    }
}
