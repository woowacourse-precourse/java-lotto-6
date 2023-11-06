package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Model;
import lotto.model.Money;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputController {
    private final Model model;
    public OutputController(Model model) {
        this.model = model;
    }

    public void printWinningLotto() {
        Arrays.stream(Money.values())
                .forEach(value -> System.out.println(value.getPrint() + " - " + model.getWinningScore().get(value) + "개"));
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
        if(count == 5 && listOfBuyLotto.getNumbers().contains(model.getBonusNumber())) count = 7;
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
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        String formattedNumber = decimalFormat.format(answer);
        System.out.println("총 수익률은 " + formattedNumber + "%입니다.");
    }
}
