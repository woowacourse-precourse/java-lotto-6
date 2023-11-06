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


    View startView = new View();
    Utils utils = new Utils();

    private Buy buy;
    private Ticket ticket = new Ticket();
    private Lotto lotto;
    private Bonus bonus;

    public void startLotto() {
        buyLotto();
        chooseHitLottoNumber();
        resultLotto();
    }

    private void buyLotto() {
        startView.buyPriceMessage();
        buyPrice();
        ticketInformation();
    }

    private void chooseHitLottoNumber() {
        startView.sixHitLottoNumberMessage();
        sixHitNumber();
        startView.bonusHitNumberMessage();
        bonusHitNumber();
    }

    public void resultLotto() {
        prizeStats();
        profitRate();
    }

    private void ticketInformation() {
        startView.buyTicketCountMessage(buy.getBuyTicketCount());
        lottoTicket();
    }

    private void lottoTicket() {
        ticket.setLottoTicket(buy.getBuyTicketCount());
        startView.lottoTicketNumbers(ticket.getLottoTicket());
    }

    private void buyPrice() {
        try {
            buy = new Buy(startView.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            buyPrice();
        }
    }

    private void sixHitNumber() {
        try {
            lotto = new Lotto(inputSixHitNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            sixHitNumber();
        }
    }

    private void bonusHitNumber() {
        try {
            bonus = new Bonus(inputBonusHitNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            bonusHitNumber();
        }
    }

    private List<Integer> inputSixHitNumber() {
        List<String> inputSixNumber = utils.stringToStringList(startView.inputConsole());
        Validate.inputSixHitLottoNumberValidate(inputSixNumber);
        return utils.stringListToIntegerList(inputSixNumber);
    }

    private int inputBonusHitNumber() {
        String inputBonusNumber = startView.inputConsole();
        Validate.inputBonusHitLottoNumberValidate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private void prizeStats() {
        startView.prizeStatsMessage();
        compareTicketAndLottoAndBonus();
        // 당첨 통계 출력
    }

    private void profitRate() {
        // 수익률 출력
    }

    private void compareTicketAndLottoAndBonus() { // 당첨 통계 출력
        // System.out.println(lotto.getNumbers());  // 이번주 당첨 번호
        // System.out.println(ticket.getLottoTicket());  // 내가 산 자동형 로또
        compareTicketsAndLotto(ticket.getLottoTicket());
    }

    private void compareTicketsAndLotto(ArrayList<ArrayList<Integer>> ticketsNumbers) {
        ticketsNumbers.forEach(ticketNumbers -> {
            int numberMatchCount = ticketNumberAndLottoNumberMatchCount(ticketNumbers, lotto.getNumbers());
            int bonusNumber = useBonusNumber(ticketNumbers);
            rankResult(numberMatchCount, bonusNumber);
        });
        System.out.println(matchRecords);
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

    private boolean rankResult(int numberMatchCount, int ticketNumberOnlyOne) {
        if (numberMatchCount == LottoRankRule.FIRST_RANK_MATCH_COUNT.getRank()) {
            matchRecords.put(Rank.FIRST_RANK.getRank(), matchRecords.get(Rank.FIRST_RANK.getRank()) + 1);
            return true;
        }
        if (numberMatchCount == LottoRankRule.SECOND_RANK_MATCH_COUNT.getRank()) {
            isMatchTicketAndBonus(ticketNumberOnlyOne, bonus.getNumber());
            return true;
        }
        if (numberMatchCount == LottoRankRule.FOURTH_RANK_MATCH_COUNT.getRank()) {
            matchRecords.put(Rank.FOURTH_RANK.getRank(), matchRecords.get(Rank.FOURTH_RANK.getRank()) + 1);
            return true;
        }
        if (numberMatchCount == LottoRankRule.FIFTH_RANK_MATCH_COUNT.getRank()) {
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
}
