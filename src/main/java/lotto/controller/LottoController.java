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

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void startLotto() {

        getPurchasePrice();
        getNumberOfLottoTicketsFromUser();
        getUserTicket();

        System.out.println();

        getWinningLottoNumberFromUser();
        getBonusNumberFromUser();

        determineEachLottoRanks();

        List<Integer> rates = new ArrayList<>();
        rates.add(first);
        rates.add(second);
        rates.add(third);
        rates.add(fourth);
        rates.add(fifth);

        float rateOfProfit = Calculator.getRateOfProfit(purchasePrice, rates);

        OutputView.printPrizeResult(rates);
        OutputView.printRateOfProfit(rateOfProfit);

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

            calculateWinnersByRank(rank);
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

    public void calculateWinnersByRank(Rank rank) {
        switch (rank) {
            case FIRST:
                first += 1;
                break;
            case SECOND:
                second += 1;
                break;
            case THIRD:
                third += 1;
                break;
            case FOURTH:
                fourth += 1;
                break;
            case FIFTH:
                fifth += 1;
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
}함