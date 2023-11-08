package lotto.controller;

import lotto.model.*;
import lotto.view.ConsoleView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private LottoTicketMoney lottoTicketMoney;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private List<Ranking> rankingResults = new ArrayList<>();
    private Map<Ranking, Integer> rankingCounts = new HashMap<>();
    private PriceMoney priceMoney = new PriceMoney(0);
    private Percent incomingRate;


    public void issueLottoTicket() {
        lottoTicketMoney = UserInput.inputPrice();
        for (int i = 0; i < lottoTicketMoney.calculateTicketNumber(); i++) {
            lottos.add(new Lotto(LottoNumberGenerator.createNumbers()));
        }
    }

    private void printLottos() {
        ConsoleView.printTicketCount(lottoTicketMoney.calculateTicketNumber());
        ConsoleView.printLottoNumbers(lottos);
    }

    private void inputWinningNumbers() {
        winningNumbers = UserInput.inputWinningLotto();
    }

    private void inputBonusNumber() { bonusNumber = UserInput.inputBonusNumber(winningNumbers); }

    public void calculateRankingResults() {
        for (Lotto lotto: lottos) {
            rankingResults.add(lotto.checkRanking(winningNumbers, bonusNumber));
        }
    }

    public Percent calculateIncomeRate(PriceMoney priceMoney) {
        return new Percent(lottoTicketMoney, priceMoney);
    }

    private void makeDefaultRankingCounts() {
        for (Ranking ranking: Ranking.values()) {
            rankingCounts.put(ranking, 0);
        }
    }

    private void countRanking() {
        for (Ranking ranking: rankingResults) {
            int currentCount = rankingCounts.get(ranking);
            rankingCounts.put(ranking, currentCount + 1);
        }
    }

    private void printRankingStatus() {
        ConsoleView.printRankingResult(rankingCounts);
    }

    private void calculatePrice() {
        rankingCounts.forEach((ranking, count) -> {
            try {
                PriceMoney currentRankingPrice = ranking.calculateCurrentPrice(count);
                priceMoney.add(currentRankingPrice);
            } catch (IllegalArgumentException illegalArgumentException) {
                ConsoleView.printErrorMessage(illegalArgumentException.getMessage());
            }
        });
    }

    private void calculateIncomeRate() {
        incomingRate = calculateIncomeRate(priceMoney);
    }

    private void printIncomeRate() {
        ConsoleView.printIncomeRate(incomingRate);
    }

    public void start() {
        issueLottoTicket();
        printLottos();
        inputWinningNumbers();
        inputBonusNumber();
        makeDefaultRankingCounts();
        calculateRankingResults();
        countRanking();
        printRankingStatus();
        calculatePrice();
        calculateIncomeRate();
        printIncomeRate();
    }
}
