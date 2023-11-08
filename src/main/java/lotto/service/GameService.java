package lotto.service;

import lotto.ui.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void playGame(){
        int tickets = ConsoleUI.amountInput();

        List<List<Integer>> bought = new ArrayList<>();
        bought = ConsoleUI.showLotto(tickets);

        List<Integer> winner = ConsoleUI.winnerInput();
        int bonus = ConsoleUI.bonusInput();
    }
}
