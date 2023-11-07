package lotto;

import static lotto.domain.utils.ConvertUtils.calculateNumberOfTickets;
import static lotto.view.LottoConsoleIn.*;
import static lotto.view.LottoConsoleOut.noticeBonusNumber;
import static lotto.view.LottoConsoleOut.noticeLottoTickets;
import static lotto.view.LottoConsoleOut.noticeTicketNumbers;
import static lotto.view.LottoConsoleOut.messageOfPurchaseAmount;
import static lotto.view.LottoConsoleOut.noticeTotalRevenueRate;
import static lotto.view.LottoConsoleOut.noticeWinningNumbers;
import static lotto.view.LottoConsoleOut.noticeWinningResult;
import static lotto.view.LottoConsoleOut.noticeWinningStatistics;

import java.util.Objects;
import lotto.domain.LottoStatus;
import lotto.domain.model.LottoTicketList;
import lotto.domain.model.LottoWinningNumber;
import lotto.domain.utils.LottoGenerator;
import lotto.domain.utils.LottoRankingService;

public class LottoGame {


    private final LottoStatus rankingStatus;

    public LottoGame() {
        this.rankingStatus = new LottoStatus();
    }

    public void play(){
        LottoTicketList tickets = purchaseTickets();
        LottoWinningNumber lottoWinningNumber = drawLottoNumbers();
        inspectTickets(tickets, lottoWinningNumber);
    }

    private void inspectTickets(LottoTicketList tickets, LottoWinningNumber lottoWinningNumber) {
        noticeWinningStatistics();
        LottoRankingService service = new LottoRankingService(lottoWinningNumber);
        tickets.getLottoTickets()
                .stream()
                .map(service::calculateRanking)
                .filter(Objects::nonNull)
                .forEach(rankingStatus::increaseRankingCount);
        noticeWinningResult(rankingStatus);
        calculateProfitRate(tickets);
    }

    private void calculateProfitRate(LottoTicketList tickets) {
        Integer purchaseAmount = getPurchaseAmount(tickets);
        Integer totalRevenue = rankingStatus.calculateTotalRevenue();
        Float totalRevenueRate = calculateRevenueRate(totalRevenue, purchaseAmount);
        noticeTotalRevenueRate(totalRevenueRate);
    }

    private int getPurchaseAmount(LottoTicketList tickets) {
        return tickets.getNumberOfTickets() * 1000;
    }


    private Float calculateRevenueRate(Integer totalRevenue, Integer purchaseAmount){
        if (totalRevenue == 0 || purchaseAmount == 0){
            return 0.0F;
        }
        return  ((float)totalRevenue/ purchaseAmount) * 100;
    }
    private LottoWinningNumber drawLottoNumbers() {
        noticeWinningNumbers();
        String stringOfWinningNumbers = inputNumberOfWinningNumbers();
        noticeBonusNumber();
        Integer bonusNumber = inputBonusNumber();
        return new LottoWinningNumber(stringOfWinningNumbers, bonusNumber);
    }

    private LottoTicketList purchaseTickets() {
        messageOfPurchaseAmount();
        Long purchaseAmount = inputPurchaseAmount();
        Integer numberOfTickets = calculateNumberOfTickets(purchaseAmount);
        noticeTicketNumbers(numberOfTickets);
        LottoTicketList tickets = LottoGenerator.generateLottoTicketList(numberOfTickets);
        noticeLottoTickets(tickets);
        return tickets;
    }
}
