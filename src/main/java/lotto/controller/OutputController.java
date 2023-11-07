package lotto.controller;

import lotto.model.single.Lotto;
import lotto.model.db.Model;
import lotto.model.single.Money;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;

import static lotto.util.Constant.OutputClass.*;

public class OutputController {
    private final Model model;
    public OutputController(Model model) {
        this.model = model;
    }

    public void printWinningLotto() {
        Arrays.stream(Money.values())
                .forEach(value -> System.out.println(value.getPrint() + PRINT_MESSAGE_WINNING_HYPHEN + model.getWinningScore().get(value) + PRINT_MESSAGE_WINNING_COUNT));
    }

    public void checkWinningLotto(){
        for (Lotto listOfBuyLotto : model.getListOfBuyLotto()) {
            int count = countLottoNumber(listOfBuyLotto);
            storeWinningLottoTicket(listOfBuyLotto, count);
        }
    }

    private int countLottoNumber(Lotto listOfBuyLotto) {
        int count = 0;
        for (Integer number : listOfBuyLotto.getNumbers()) {
            if (model.getLotto().getNumbers().contains(number)) count ++;
        }
        return count;
    }

    private void storeWinningLottoTicket(Lotto listOfBuyLotto, int count) {
        Map<Money, Integer> winningScoreList = model.getWinningScore();
        if(count == Money.FIFTH.getNumber() && listOfBuyLotto.getNumbers().contains(model.getBonusNumber())) count = Money.FIFTH_BONUS.getNumber();
        Money money = Money.checkTicketScore(count);
        if (money != null) winningScoreList.put(money, winningScoreList.get(money) + 1);
    }

    public void printRateOfReturn() {
        int ticketCount = model.getTicketCount();
        Map<Money, Integer> winningScoreList = model.getWinningScore();
        int proceeds = winningScoreList.keySet().stream()
                .mapToInt(money -> money.getPrice() * winningScoreList.get(money))
                .sum();
        double answer = (double) proceeds / ticketCount * 100.00;
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        String formattedNumber = decimalFormat.format(answer);
        System.out.println(PRINT_MESSAGE_TOTAL_PROCEEDS + formattedNumber + PRINT_MESSAGE_TOTAL_PROCEEDS_PERCENTAGE);
    }
}
