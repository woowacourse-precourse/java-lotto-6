package lotto.Controller;

import lotto.Domain.Human;

public class LottoController {
    private Human human;

    public void gameStart(String budgets) {
        // Exception Checking will be here
        human = new Human(Long.parseLong(budgets));
        System.out.println(budgets);
    }
}
