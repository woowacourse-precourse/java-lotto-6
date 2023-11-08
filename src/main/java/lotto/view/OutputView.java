package lotto.view;

import static lotto.view.Sentence.*;

import lotto.global.util.StringConverter.IntegerListToStringConverter;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.WinningStatistic;

public class OutputView {

    private static OutputView outputView = new OutputView();
    IntegerListToStringConverter integerListToStringConverter = IntegerListToStringConverter.getInstance();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printInputPurchaseAmountNotice(){
        System.out.print(INPUT_PURCHASE_AMOUNT.getSentence());
    }

    public void printOutputPurchaseAmount(int purchaseAmount){
        System.out.print(purchaseAmount+ OUTPUT_PURCHASE_AMOUNT.getSentence());
    }

    public void printPurchaseLottoTicketsInfo(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(makeLottoTicketInfo(lotto));
        }
        System.out.println();
    }

    private String makeLottoTicketInfo(Lotto lotto) {
        String lottoTicketInfo = "[";
        lottoTicketInfo += integerListToStringConverter.convert(lotto.getLottoNumbers());
        lottoTicketInfo += "]";
        return lottoTicketInfo;
    }

    public void printInputWinningNumbersNotice(){
        System.out.print(INPUT_WINNING_NUMBERS.getSentence());
    }

    public void printInputBonusNumberNotice(){
        System.out.print(INPUT_BONUS_NUMBER.getSentence());
    }

    public void printWinningStatisticsInfo(WinningStatistic winningStatistic){
        System.out.print(OUTPUT_WINNING_STATISTICS.getSentence());

        System.out.print(OUTPUT_WINNING_THREE_MATCHES.getSentence() + winningStatistic.threeMatchCount()
                + OUTPUT_WINNING_MATCHES_COUNT.getSentence());
        System.out.print(OUTPUT_WINNING_FOUR_MATCHES.getSentence() + winningStatistic.fourMatchCount()
                + OUTPUT_WINNING_MATCHES_COUNT.getSentence());
        System.out.print(OUTPUT_WINNING_FIVE_MATCHES.getSentence() + winningStatistic.fiveMatchCount()
                + OUTPUT_WINNING_MATCHES_COUNT.getSentence());
        System.out.print(OUTPUT_WINNING_FIVE_AND_BONUS_MATCHES.getSentence() + winningStatistic.fiveAndBonusMatchCount()
                + OUTPUT_WINNING_MATCHES_COUNT.getSentence());
        System.out.print(OUTPUT_WINNING_SIX_MATCHES.getSentence() + winningStatistic.sixMatchCount()
                + OUTPUT_WINNING_MATCHES_COUNT.getSentence());
    }

    public void printTotalReturn(float totalReturn){
        System.out.print(OUTPUT_TOTAL_RETURN_FRONT.getSentence() + String.valueOf(totalReturn)
                + OUTPUT_TOTAL_RETURN_BACK.getSentence());
    }


}
