package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.GetLottoNumber;
import lotto.util.Calculator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

import static lotto.model.Rank.*;

public class LottoController {

    private List<Lotto> userTickets = new ArrayList<>();
    private Lotto winningTicket;
    private int bonusNumber;
    private int purchasePrice;
    int numberOfLottoTickets;

    int[] rankBoard = {0,0,0,0,0,0,0,0};

    public void startLotto() {

        getPurchasePrice();
        getNumberOfLottoTicketsFromUser();
        getUserTicket();

        System.out.println();

        getWinningLottoNumberFromUser();
        getBonusNumberFromUser();
        determineEachLottoRanks();
        getResult();

    }

    private void getPurchasePrice() {
        OutputView.printGetPurchasePriceMessage();
        purchasePrice = InputView.inputPurchasePrice();
    }

    public void getNumberOfLottoTicketsFromUser() {
        numberOfLottoTickets = Calculator.getNumberOfLottoTickets(purchasePrice);
        OutputView.printLottoNumMessage(numberOfLottoTickets);
    }

    public void getUserTicket() {
        for(int i = 0; i < numberOfLottoTickets ; i++) {
            List<Integer> lottoNumber = GetLottoNumber.getLottoNumber();
            OutputView.printLottoNumber(lottoNumber);
            userTickets.add(new Lotto(lottoNumber));
        }
    }

    public void getWinningLottoNumberFromUser() {
        OutputView.printWinNumberMessage();
        winningTicket = GetLottoNumber.getWinLottoNumber();
    }

    public void getBonusNumberFromUser() {
        OutputView.printBonusNumberMessage();
        bonusNumber = GetLottoNumber.getBonusNumber();
    }

    public void determineEachLottoRanks() {
        for (int i = 0; i < userTickets.size(); i++) {
            List<Integer> userNumbers = userTickets.get(i).getNumbers();
            List<Integer> winningNumbers = winningTicket.getNumbers();

            int matchingNumberCount = countMatchingNumbers(userNumbers, winningNumbers);
            Rank rank = getRank(userTickets, matchingNumberCount);

            calculateWinnersByRank(rank, rankBoard);
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

    public void calculateWinnersByRank(Rank rank, int[] rankBoard) {
        switch (rank) {
            case FIRST:
                rankBoard[1] += 1;
                break;
            case SECOND:
                rankBoard[2] += 2;
                break;
            case THIRD:
                rankBoard[3] += 1;
                break;
            case FOURTH:
                rankBoard[4] += 1;
                break;
            case FIFTH:
                rankBoard[5] += 1;
                break;
        }
    }

    private Rank getRank(List<Lotto> userNumbers, int matchCount) {
        if (matchCount == 5 && userNumbers.contains(bonusNumber)) {
            return SECOND;
        }

        switch (matchCount) {
            case 6:
                return FIRST;
            case 5:
                return THIRD;
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            case 2, 1, 0:
                return LOOSE;
        }

        return LOOSE;
    }

    public void getResult() {
        float rateOfProfit = Calculator.getRateOfProfit(purchasePrice, rankBoard);

        OutputView.printPrizeResult(rankBoard);
        OutputView.printRateOfProfit(rateOfProfit);
    }
}