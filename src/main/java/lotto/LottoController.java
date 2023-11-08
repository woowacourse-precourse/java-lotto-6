package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void playGame(){
        int tickets = LottoView.amountInput();

        List<List<Integer>> bought = new ArrayList<>();
        bought = LottoView.showLotto(tickets);

        List<Integer> winner = LottoView.winnerInput();
        int bonus = LottoView.bonusInput();

        LottoView.printResult(bought, winner, bonus);
    }
}