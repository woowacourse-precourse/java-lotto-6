package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.common.constants.GuideMessage;
import lotto.common.constants.Rank;
import lotto.common.constants.RankMessage;
import lotto.common.constants.Symbol;
import lotto.common.constants.Unit;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;

public class View {
    public String inputConsole() {
        String input = Console.readLine();
        Validate.consoleBlank(input);
        return input;
    }

    public void buyPriceMessage() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE.getMessage());
    }

    public void buyTicketCountMessage(int ticketCount) {
        System.out.println(ticketCount + GuideMessage.OUTPUT_BUY_LOTTO_COUNT.getMessage());
    }

    public void lottoTicketNumbers(ArrayList<ArrayList<Integer>> lottoTickets) {
        lottoTicketInformation(lottoTickets);
        System.out.println();
    }

    private void lottoTicketInformation(ArrayList<ArrayList<Integer>> lottoTickets) {
        for (ArrayList<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void sixHitLottoNumberMessage() {
        System.out.println(GuideMessage.INPUT_HIT_NUMBER.getMessage());
    }

    public List<Integer> inputSixHitNumber() {
        List<String> inputSixNumber = Utils.stringToStringList(inputConsole());
        Validate.inputSixHitLottoNumberValidate(inputSixNumber);
        return Utils.stringListToIntegerList(inputSixNumber);
    }

    public void bonusHitNumberMessage() {
        System.out.println(GuideMessage.INPUT_BONUS_HIT_NUMBER.getMessage());
    }

    public int inputBonusHitNumber() {
        String inputBonusNumber = inputConsole();
        Validate.inputBonusHitLottoNumberValidate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    public void prizeStatsMessage() {
        System.out.println(GuideMessage.OUTPUT_PRIZE_STATS.getMessage());
        System.out.println(Symbol.DIVIDE_LINE.getSymbol());
    }

    public void outputPrizeStats(Map<String, Integer> matchRecords) {
        System.out.println(RankMessage.FIFTH_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FIFTH_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.FOURTH_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FOURTH_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.THIRD_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.THIRD_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.SECOND_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.SECOND_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
        System.out.println(RankMessage.FIRST_RANK_MESSAGE.getMessage() + matchRecords.get(Rank.FIRST_RANK.getRank()) + Unit.TOTAL_NUMBER.getUnit());
    }

    public void outputProfitRate(double percentageResult) {
        System.out.println(GuideMessage.OUTPUT_TOTAL_PROFIT_PRICE_START.getMessage() + String.format("%.1f", percentageResult) + GuideMessage.OUTPUT_TOTAL_PROFIT_PRICE_END.getMessage());
    }
}
