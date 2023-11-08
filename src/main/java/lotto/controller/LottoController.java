package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constants.LottoRule;
import lotto.common.constants.LottoRank;
import lotto.common.constants.Rank;
import lotto.common.utils.Parser;
import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.BuyInformation;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.View;

public class LottoController {
    private Map<String, Integer> rankRecord = new HashMap<String, Integer>() {{
        put(Rank.FIRST_RANK.getRank(), 0);
        put(Rank.SECOND_RANK.getRank(), 0);
        put(Rank.THIRD_RANK.getRank(), 0);
        put(Rank.FOURTH_RANK.getRank(), 0);
        put(Rank.FIFTH_RANK.getRank(), 0);
    }};

    View view = new View();

    private BuyInformation buyInformation;
    private final Ticket ticket = new Ticket();
    private Lotto lotto;
    private Bonus bonus;

    public void startLotto() {
        buyLotto();
        view.printLottoNumberMessage();
        initLottoNumber();
        view.printBonusNumberMessage();
        initBonusNumber();
        resultLotto();
    }

    private void buyLotto() {
        view.printBuyPriceMessage();
        initBuyInformation();
        initTicket();
    }

    private void resultLotto() {
        view.printPrizeStatsMessage();
        compareTicketsAndLotto(ticket.getLottoTicket(), lotto.getNumbers(), bonus.getNumber());
        view.printPrizeStats(rankRecord);
        view.printProfitRate(Parser.percentage(buyInformation.getMoney(), calculateTotalProfit()));
    }

    private void initBuyInformation() {
        try {
            buyInformation = new BuyInformation(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            initBuyInformation();
        }
    }

    private void initTicket() {
        view.printBuyTicketCountMessage(buyInformation.getBuyTicketCount());
        ticket.setLottoTicket(buyInformation.getBuyTicketCount());
        view.printLottoTicketInformation(ticket.getLottoTicket());
    }

    private void initLottoNumber() {
        try {
            lotto = new Lotto(view.inputLottoNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            initLottoNumber();
        }
    }

    private void initBonusNumber() {
        try {
            bonus = new Bonus(view.inputBonusNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            initBonusNumber();
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
        return LottoRule.PICK_HIT_NUMBER_TOTAL.getRule() - ticketNumbers.size();
    }

    private int remainNumberOrZero(List<Integer> ticketNumbers) {
        if (ticketNumbers.size() == 1) {
            return ticketNumbers.get(0);
        }
        return 0;
    }

    private boolean decideRank(int matchCount, int remainNumberOrZero, int bonusNumber) {
        if (matchCount == LottoRank.FIRST_RANK_MATCH_COUNT.getRank()) {
            rankRecord.put(Rank.FIRST_RANK.getRank(), rankRecord.get(Rank.FIRST_RANK.getRank()) + 1);
            return true;
        } if (matchCount == LottoRank.SECOND_RANK_MATCH_COUNT.getRank()) {
            decideRankSecondOrThird(remainNumberOrZero, bonusNumber);
            return true;
        } if (matchCount == LottoRank.FOURTH_RANK_MATCH_COUNT.getRank()) {
            rankRecord.put(Rank.FOURTH_RANK.getRank(), rankRecord.get(Rank.FOURTH_RANK.getRank()) + 1);
            return true;
        } if (matchCount == LottoRank.FIFTH_RANK_MATCH_COUNT.getRank()) {
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
        return LottoRank.FIRST_RANK_PRICE.getRank() * rankRecord.get(Rank.FIRST_RANK.getRank())
                + LottoRank.SECOND_RANK_PRICE.getRank() * rankRecord.get(Rank.SECOND_RANK.getRank())
                + LottoRank.THIRD_RANK_PRICE.getRank() * rankRecord.get(Rank.THIRD_RANK.getRank())
                + LottoRank.FOURTH_RANK_PRICE.getRank() * rankRecord.get(Rank.FOURTH_RANK.getRank())
                + LottoRank.FIFTH_RANK_PRICE.getRank() * rankRecord.get(Rank.FIFTH_RANK.getRank());
    }
}
