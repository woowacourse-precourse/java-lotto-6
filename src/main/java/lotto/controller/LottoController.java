package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.Calculator;
import lotto.service.GetLottoNumber;
import lotto.service.RankingService;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {

    private final List<Lotto> userTickets = new ArrayList<>();
    private Lotto winningTicket;
    private int bonusNumber;
    private int purchasePrice;
    int numberOfLottoTickets;

    int[] rankBoard = {0,0,0,0,0,0,0,0};

    public void startLotto() {

        getPurchasePriceFromUser();
        calculateNumberOfLottoTickets();
        getUserTicket();

        System.out.println();

        getWinningLottoNumberFromUser();
        getBonusNumberFromUser();
        determineEachLottoRanks();
        getResult();

    }

    private void getPurchasePriceFromUser() {
        OutputView.printGetPurchasePriceMessage();
        purchasePrice = GetLottoNumber.purchasePrice();

    }

    public void calculateNumberOfLottoTickets() {
        numberOfLottoTickets = Calculator.numberOfLottoTickets(purchasePrice);
        OutputView.printLottoNumMessage(numberOfLottoTickets);
    }

    public void getUserTicket() {
        for(int i = 0; i < numberOfLottoTickets ; i++) {
            List<Integer> lottoNumber = GetLottoNumber.userTicketNumbers();
            OutputView.printLottoNumber(lottoNumber);
            userTickets.add(new Lotto(lottoNumber));
        }
    }

    public void getWinningLottoNumberFromUser() {
        OutputView.printWinNumberMessage();
        try {
            winningTicket = GetLottoNumber.winningTicketNumbers();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWinningLottoNumberFromUser();
        }
    }

    public void getBonusNumberFromUser() {
        OutputView.printBonusNumberMessage();
        bonusNumber = GetLottoNumber.bonusNumber();
    }

    public void determineEachLottoRanks() {
        for (int i = 0; i < userTickets.size(); i++) {
            List<Integer> userNumbers = userTickets.get(i).getNumbers();
            List<Integer> winningNumbers = winningTicket.getNumbers();

            int matchingNumberCount = countMatchingNumbers(userNumbers, winningNumbers);
            Rank rank = RankingService.getRank(userNumbers, matchingNumberCount, bonusNumber);

            RankingService.calculateWinnersByRank(rank, rankBoard);
        }
    }

    public int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int matchedNumbers = 0;

        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                matchedNumbers++;
            }
        }

        return matchedNumbers;
    }

    public void getResult() {
        float rateOfProfit = Calculator.rateOfProfit(purchasePrice, rankBoard);

        OutputView.printPrizeResult(rankBoard);
        OutputView.printRateOfProfit(rateOfProfit);
    }
}