package lotto.view;


import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.constants.RequestMessage;
import lotto.view.constants.ResponseMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestPurchaseAmount() {
        System.out.println(RequestMessage.PURCHASE_AMOUNT.getMessage());
    }

    public static void printRequestWinningNumber() {
        System.out.println(RequestMessage.WINNING_NUMBER.getMessage());
    }

    public static void printRequestBonusNumber() {
        System.out.println();
        System.out.println(RequestMessage.BONUS_NUMBER.getMessage());
    }

    public static void printPurchaseResult(LottoTicket lottoTicket) {
        System.out.println();

        String formattedMessage = String.format(ResponseMessage.PURCHASE_COUNT.getMessage(),
                lottoTicket.getLottoCount());
        System.out.println(formattedMessage);

        lottoTicket.getTickets().stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);

        System.out.println();
    }

    public static void printResponseWinningStats(LottoResult lottoResult) {
        System.out.println();

        String formattedMessage =
                String.format(ResponseMessage.WINNING_STATS.getMessage(),
                        lottoResult.getCountOfRank(LottoRank.FIFTH),
                        lottoResult.getCountOfRank(LottoRank.FOURTH),
                        lottoResult.getCountOfRank(LottoRank.THIRD),
                        lottoResult.getCountOfRank(LottoRank.SECOND),
                        lottoResult.getCountOfRank(LottoRank.FIRST));
        System.out.println(formattedMessage);
    }

    public static void printResponseProfitRate(LottoResult lottoResult, LottoTicket lottoTicket) {
        double profitRate = lottoResult.getTotalEarnings() / lottoTicket.getLottoCount() / 10;

        String formattedMessage =
                String.format(ResponseMessage.WINNING_PROFIT_RATE.getMessage(),
                        profitRate);

        System.out.println(formattedMessage);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
