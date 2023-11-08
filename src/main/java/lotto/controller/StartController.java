package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constants.LottoDefaultRule;
import lotto.common.constants.LottoRankRule;
import lotto.common.constants.Rank;
import lotto.common.utils.Parser;
import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.View;

public class StartController {
    Map<String, Integer> rankRecord = new HashMap<String, Integer>() {{
        put(Rank.FIRST_RANK.getRank(), 0);
        put(Rank.SECOND_RANK.getRank(), 0);
        put(Rank.THIRD_RANK.getRank(), 0);
        put(Rank.FOURTH_RANK.getRank(), 0);
        put(Rank.FIFTH_RANK.getRank(), 0);
    }};

    View view = new View();

    private Buy buy;
    private final Ticket ticket = new Ticket();
    private Lotto lotto;
    private Bonus bonus;

    public void startLotto() {
        buyLotto();
        chooseHitLottoNumber();
        resultLotto();
    }

    private void buyLotto() {
        view.buyPriceMessage();
        money();
        ticketInformation();
    }

    private void chooseHitLottoNumber() {
        view.lottoNumberMessage();
        lottoNumber();
        view.bonusNumberMessage();
        bonusNumber();
    }

    private void resultLotto() {
        view.prizeStatsMessage();
        compareTicketsAndLotto(ticket.getLottoTicket(), lotto.getNumbers(), bonus.getNumber());
        view.prizeStats(rankRecord);
        view.profitRate(Parser.percentage(buy.getMoney(), calculateTotalProfit()));
    }

    private void money() {
        try {
            buy = new Buy(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            money();
        }
    }

    private void ticketInformation() {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
        ticket.setLottoTicket(buy.getBuyTicketCount());
        view.lottoTicketInformation(ticket.getLottoTicket());
    }

    private void lottoNumber() {
        try {
            lotto = new Lotto(view.inputLottoNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            lottoNumber();
        }
    }

    private void bonusNumber() {
        try {
            bonus = new Bonus(view.inputBonusNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            bonusNumber();
        }
    }

    private void compareTicketsAndLotto(ArrayList<ArrayList<Integer>> ticketsNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        ticketsNumbers.forEach(ticketNumbers -> {
            int matchCount = ticketNumberAndLottoNumberMatchCount(ticketNumbers, lottoNumbers);
            int remainNumberOrZero = remainNumberOrZero(ticketNumbers);
            decideRank(matchCount, remainNumberOrZero, bonusNumber);
        });
    }

    private int ticketNumberAndLottoNumberMatchCount(List<Integer> ticketNumbers, List<Integer> lottoNumbers) {
        ticketNumbers.removeAll(lottoNumbers);
        return LottoDefaultRule.PICK_HIT_NUMBER_TOTAL.getRule() - ticketNumbers.size();
    }

    private int remainNumberOrZero(List<Integer> ticketNumbers) {
        if (ticketNumbers.size() == 1) {
            return ticketNumbers.get(0);
        }
        return 0;
    }

    private boolean decideRank(int matchCount, int remainNumberOrZero, int bonusNumber) {
        if (matchCount == LottoRankRule.FIRST_RANK_MATCH_COUNT.getRank()) {
            rankRecord.put(Rank.FIRST_RANK.getRank(), rankRecord.get(Rank.FIRST_RANK.getRank()) + 1);
            return true;
        } if (matchCount == LottoRankRule.SECOND_RANK_MATCH_COUNT.getRank()) {
            decideRankSecondOrThird(remainNumberOrZero, bonusNumber);
            return true;
        } if (matchCount == LottoRankRule.FOURTH_RANK_MATCH_COUNT.getRank()) {
            rankRecord.put(Rank.FOURTH_RANK.getRank(), rankRecord.get(Rank.FOURTH_RANK.getRank()) + 1);
            return true;
        } if (matchCount == LottoRankRule.FIFTH_RANK_MATCH_COUNT.getRank()) {
            rankRecord.put(Rank.FIFTH_RANK.getRank(), rankRecord.get(Rank.FIFTH_RANK.getRank()) + 1);
            return true;
        }
        return true;
    }

    private boolean decideRankSecondOrThird(int ticketNumber, int bonusNumber) {
        if (ticketNumber == bonusNumber) {
            rankRecord.put(Rank.SECOND_RANK.getRank(), rankRecord.get(Rank.SECOND_RANK.getRank()) + 1);
            return true;
        }
        rankRecord.put(Rank.THIRD_RANK.getRank(), rankRecord.get(Rank.THIRD_RANK.getRank()) + 1);
        return true;
    }

    private int calculateTotalProfit() {
        return LottoRankRule.FIRST_RANK_PRICE.getRank() * rankRecord.get(Rank.FIRST_RANK.getRank())
                + LottoRankRule.SECOND_RANK_PRICE.getRank() * rankRecord.get(Rank.SECOND_RANK.getRank())
                + LottoRankRule.THIRD_RANK_PRICE.getRank() * rankRecord.get(Rank.THIRD_RANK.getRank())
                + LottoRankRule.FOURTH_RANK_PRICE.getRank() * rankRecord.get(Rank.FOURTH_RANK.getRank())
                + LottoRankRule.FIFTH_RANK_PRICE.getRank() * rankRecord.get(Rank.FIFTH_RANK.getRank());
    }
}
