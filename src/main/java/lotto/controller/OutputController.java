package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Model;
import lotto.model.Money;

import java.util.List;
import java.util.Map;

public class OutputController {
    private final Model model;
    public OutputController(Model model) {
        this.model = model;
    }

    public List<Lotto> getListOfBuyLotto() {
        return model.getListOfBuyLotto();
    }

    public void printWinningLotto() {
        model.getWinningScore().forEach((money, integer) -> {
            System.out.println(money.getPrint() + " - " + integer + "개");
        });
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
}
