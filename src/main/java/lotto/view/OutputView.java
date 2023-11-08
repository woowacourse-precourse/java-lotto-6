package lotto.view;

import lotto.Lotto;
import lotto.model.LottoRankResult;
import lotto.view.enums.ErrorMessage;
import lotto.view.enums.PrintMessage;
import lotto.view.enums.RankMessage;
import lotto.model.enums.PrizeInfo;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public void printInputPurchaseMoney() {
        System.out.println(PrintMessage.INPUT_PURCHASE_MONEY.getMessage());
    }

    public void printInputWinningNumbers() {
        System.out.println(PrintMessage.INPUT_WINNING_NUMBER.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printTicketNumber(int ticketNumber) {
        String output = ticketNumber + PrintMessage.TICKET_NUMBER_FOOTER.getMessage();
        System.out.println(output);
    }

    public void printLottos(List<Lotto> lottos) {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottos) {
            builder.append(PrintMessage.LOTTO_NUMBER_HEADER.getMessage());
            builder.append(makeLottoString(lotto));
            builder.append(PrintMessage.LOTTO_NUMBER_FOOTER.getMessage());
        }
        System.out.println(builder);
    }

    private String makeLottoString(Lotto lotto) {
        List<String> numbers = lotto
                .getNumbers()
                .stream()
                .sorted()
                .map(Object::toString)
                .toList();
        return String.join(PrintMessage.JOIN_DELIMITER.getMessage(), numbers);
    }

    public void printLottoResult(LottoRankResult rankResult) {
        StringBuilder builder = new StringBuilder();
        builder.append(PrintMessage.WINNING_HEADER.getMessage());
        builder.append(PrintMessage.THREE_HYPHEN.getMessage());
        builder.append(makeRankString(rankResult));
        System.out.print(builder);
    }

    private String makeRankString(LottoRankResult rankResult) {
        StringBuilder builder = new StringBuilder();
        for (int rank = PrizeInfo.PRIZE_5.getRank(); rank >= PrizeInfo.PRIZE_1.getRank(); rank--) {
            builder.append(RankMessage.getMessageByRank(rank));
            builder.append(rankResult.getCount(rank));
            builder.append(PrintMessage.RANK_FOOTER.getMessage());
        }
        return builder.toString();
    }

    public void printRateOfReturn(double rateOfReturn) {
        StringBuilder builder = new StringBuilder();
        builder.append(PrintMessage.RATE_OF_RETURN_HEADER.getMessage());
        builder.append(String.format("%.1f", rateOfReturn));
        builder.append(PrintMessage.RATE_OF_RETURN_FOOTER.getMessage());
        System.out.println(builder);
    }

    public void printErrorMessage(String message) {
        String errorMessage = ErrorMessage.ERROR_HEADER.getMessage()
                + message
                + ErrorMessage.ERROR_FOOTER.getMessage();
        System.out.println(errorMessage);
    }

    public void printBlankLine() {
        System.out.println();
    }
}
