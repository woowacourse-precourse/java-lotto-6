package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

import static lotto.model.Rank.*;

public class LottoController {

    private static final int TICKET_PRICE = 1000;
    private static final float PERCENTAGE = 100;

    private List<Lotto> userTickets = new ArrayList<>();
    private Lotto winningTicket;
    private int bonusNumber;

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void startLotto() {
        OutputView.printGetPurchasePriceMessage();
        int purchasePrice = InputView.inputPurchasePrice();

        int lottoNum = getLottoNum(purchasePrice);
        OutputView.printLottoNumMessage(lottoNum);

        for(int i = 0; i < lottoNum ; i++) {
            List<Integer> lottoNumber = getLottoNumber();
            OutputView.printLottoNumber(lottoNumber);
            userTickets.add(new Lotto(lottoNumber));
        }

        System.out.println();

        OutputView.printWinNumberMessage();
        getWinLottoNumber();

        OutputView.printBonusNumberMessage();
        bonusNumber = getBonusNumber();

        for (int i = 0; i < userTickets.size(); i++) {

            List<Integer> userNumbers = userTickets.get(i).getNumbers();
            List<Integer> winningNumbers = winningTicket.getNumbers();

            int matchCount = countMatchingNumbers(userNumbers, winningNumbers);
            Rank rank = setRank(userTickets, matchCount);

            getResult(rank);
        }

        List<Integer> rates = new ArrayList<>();
        rates.add(first);
        rates.add(second);
        rates.add(third);
        rates.add(fourth);
        rates.add(fifth);

        float rateOfProfit = getRateOfProfit(purchasePrice, rates);

        OutputView.printPrizeResult(rates);
        OutputView.printRateOfProfit(rateOfProfit);

    }

    public void getResult(Rank rank) {
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

    public int getLottoNum(int purchasePrice) {
        int lottoNum = purchasePrice / TICKET_PRICE;
        return lottoNum;
    }

    public List<Integer> getLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> modifiableList = new ArrayList<>(lottoNumber);
        Collections.sort(modifiableList);
        return modifiableList;
    }

    public void getWinLottoNumber() {
        List<Integer> winNumber = InputView.inputWinNumber();

        try {
            winningTicket = new Lotto(winNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("당첨 번호를 6개 입력해주세요.");
            getWinLottoNumber();
        }
    }

    public int getBonusNumber() {
        int bonusNumber = InputView.inputBonusNumber();

        try {
            Validator.bonusNumberNum(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("1개만 입력하세요.");
            getLottoNumber();
        }

        return bonusNumber;
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

    private Rank setRank(List<Lotto> userNumbers, int matchCount) {

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
            case 2:
                return LOOSE;
            case 1:
                return LOOSE;
            case 0:
                return LOOSE;
        }

        return LOOSE;

    }

    private float getRateOfProfit(int purchasePrice, List<Integer> rates) {
        float totalPrize = getTotalPrize(rates);
        float rateOfProfit = (totalPrize / (float) purchasePrice) * PERCENTAGE;
        return rateOfProfit;
    }

    private int getTotalPrize(List<Integer> rates) {
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += getRatePrice(i + 1, rates.get(i));
        }
        return total;
    }

    private int getRatePrice(int rate, int rateNum) {

        switch (rate) {
            case 5:
                return 5000 * rateNum;
            case 4:
                return 50000 * rateNum;
            case 3:
                return 1500000 * rateNum;
            case 2:
                return 30000000 * rateNum;
            case 1:
                return 2000000000 * rateNum;
        }

        return 0;

    }
}
