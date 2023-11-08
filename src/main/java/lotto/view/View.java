package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.common.constants.OutputMessage;
import lotto.common.constants.Rank;
import lotto.common.constants.RankMessage;
import lotto.common.constants.Symbol;
import lotto.common.constants.Unit;
import lotto.common.utils.Parser;
import lotto.common.validate.Validate;

public class View {
    public String inputConsole() {
        String input = Console.readLine();
        Validate.consoleBlankValidate(input);
        return input;
    }

    public void printBuyPriceMessage() {
        System.out.println(OutputMessage.INPUT_BUY_PRICE.getMessage());
    }

    public void printBuyTicketCountMessage(int ticketCount) {
        System.out.println(ticketCount + OutputMessage.OUTPUT_BUY_LOTTO_COUNT.getMessage());
    }

    public void printLottoTicketInformation(ArrayList<ArrayList<Integer>> lottoTickets) {
        printLottoTickets(lottoTickets);
        System.out.println();
    }

    private void printLottoTickets(ArrayList<ArrayList<Integer>> lottoTickets) {
        for (ArrayList<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printLottoNumberMessage() {
        System.out.println(OutputMessage.INPUT_HIT_NUMBER.getMessage());
    }

    public List<Integer> inputLottoNumber() {
        List<String> inputSixNumber = Parser.stringToStringList(inputConsole());
        Validate.inputLottoNumberValidate(inputSixNumber);
        return Parser.stringListToIntegerList(inputSixNumber);
    }

    public void printBonusNumberMessage() {
        System.out.println(OutputMessage.INPUT_BONUS_HIT_NUMBER.getMessage());
    }

    public int inputBonusNumber() {
        String inputBonusNumber = inputConsole();
        Validate.inputBonusLottoNumberValidate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    public void printPrizeStatsMessage() {
        System.out.println(OutputMessage.OUTPUT_PRIZE_STATS.getMessage());
        System.out.println(Symbol.DIVIDE_LINE.getSymbol());
    }

    public void printPrizeStats(Map<String, Integer> matchRecords) {
        System.out.println(RankMessage.FIFTH_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FIFTH_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.FOURTH_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FOURTH_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.THIRD_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.THIRD_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.SECOND_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.SECOND_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.FIRST_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FIRST_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
    }

    public void printProfitRate(double percentageResult) {
        System.out.println(
                OutputMessage.OUTPUT_TOTAL_PROFIT_PRICE_START.getMessage() + String.format("%.1f", percentageResult) + OutputMessage.OUTPUT_TOTAL_PROFIT_PRICE_END.getMessage());
    }
}
