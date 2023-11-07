package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constants.LottoDefaultRule;
import lotto.common.constants.LottoRankRule;
import lotto.common.constants.Rank;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.View;

public class StartController {
    Map<String, Integer> matchRecords = new HashMap<String, Integer>() {{
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
        buyPrice();
        ticketInformation();
    }

    private void chooseHitLottoNumber() {
        view.sixHitLottoNumberMessage();
        sixHitNumber();
        view.bonusHitNumberMessage();
        bonusHitNumber();
    }

    public void resultLotto() {
        view.prizeStatsMessage();
        compareTicketsAndLotto(ticket.getLottoTicket(), lotto.getNumbers(), bonus.getNumber());
        view.outputPrizeStats(matchRecords);
        view.outputProfitRate(Utils.percentage(buy.getBuyPrice(), calculateTotalProfitPrice()));
    }

    private void buyPrice() {
        try {
            buy = new Buy(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            buyPrice();
        }
    }

    private void ticketInformation() {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
        ticket.setLottoTicket(buy.getBuyTicketCount());
        view.lottoTicketNumbers(ticket.getLottoTicket());
    }

    private void sixHitNumber() {
        try {
            lotto = new Lotto(view.inputSixHitNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            sixHitNumber();
        }
    }

    private void bonusHitNumber() {
        try {
            bonus = new Bonus(view.inputBonusHitNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            bonusHitNumber();
        }
    }

    private void compareTicketsAndLotto(ArrayList<ArrayList<Integer>> ticketsNumbers, List<Integer> lottoNumbers, int bonusNumber) {
        ticketsNumbers.forEach(ticketNumbers -> {
            int numberMatchCount = ticketNumberAndLottoNumberMatchCount(ticketNumbers, lottoNumbers);
            int ticketBonusNumber = useBonusNumber(ticketNumbers);
            rankResult(numberMatchCount, ticketBonusNumber, bonusNumber);
        });
    }

    private int ticketNumberAndLottoNumberMatchCount(List<Integer> ticketNumbers, List<Integer> lottoNumbers) {
        ticketNumbers.removeAll(lottoNumbers);
        return LottoDefaultRule.PICK_HIT_NUMBER_TOTAL.getRule() - ticketNumbers.size();
    }

    private int useBonusNumber(List<Integer> ticketNumbers) {
        if (ticketNumbers.size() == 1) {
            return ticketNumbers.get(0);
        }
        return 0;
    }

    private boolean rankResult(int numberMatchCount, int ticketNumberOnlyOne, int bonusNumber) {
        if (numberMatchCount == LottoRankRule.FIRST_RANK_MATCH_COUNT.getRank()) {
            matchRecords.put(Rank.FIRST_RANK.getRank(), matchRecords.get(Rank.FIRST_RANK.getRank()) + 1);
            return true;
        } if (numberMatchCount == LottoRankRule.SECOND_RANK_MATCH_COUNT.getRank()) {
            isMatchTicketAndBonus(ticketNumberOnlyOne, bonusNumber);
            return true;
        } if (numberMatchCount == LottoRankRule.FOURTH_RANK_MATCH_COUNT.getRank()) {
            matchRecords.put(Rank.FOURTH_RANK.getRank(), matchRecords.get(Rank.FOURTH_RANK.getRank()) + 1);
            return true;
        } if (numberMatchCount == LottoRankRule.FIFTH_RANK_MATCH_COUNT.getRank()) {
            matchRecords.put(Rank.FIFTH_RANK.getRank(), matchRecords.get(Rank.FIFTH_RANK.getRank()) + 1);
            return true;
        }
        return true;
    }

    private boolean isMatchTicketAndBonus(int ticketNumber, int bonusNumber) { // 번호가 5개 일치할 경우 진입
        if (ticketNumber == bonusNumber) {
            matchRecords.put(Rank.SECOND_RANK.getRank(), matchRecords.get(Rank.SECOND_RANK.getRank()) + 1);
            return true;
        }
        matchRecords.put(Rank.THIRD_RANK.getRank(), matchRecords.get(Rank.THIRD_RANK.getRank()) + 1);
        return true;
    }

    private int calculateTotalProfitPrice() {
        return LottoRankRule.FIRST_RANK_PRICE.getRank() * matchRecords.get(Rank.FIRST_RANK.getRank())
                + LottoRankRule.SECOND_RANK_PRICE.getRank() * matchRecords.get(Rank.SECOND_RANK.getRank())
                + LottoRankRule.THIRD_RANK_PRICE.getRank() * matchRecords.get(Rank.THIRD_RANK.getRank())
                + LottoRankRule.FOURTH_RANK_PRICE.getRank() * matchRecords.get(Rank.FOURTH_RANK.getRank())
                + LottoRankRule.FIFTH_RANK_PRICE.getRank() * matchRecords.get(Rank.FIFTH_RANK.getRank());
    }
}
