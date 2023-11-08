package lotto;

import lotto.controller.Controller;
import lotto.model.Lotto;
import lotto.model.ValidValues;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        ValidValues validValues = new ValidValues();
        Output output = new Output();

        Controller controller = new Controller(input, validValues);
        int price = controller.getPurchasePrice().price;
        List<List<Integer>> tickets = controller.generateLottoTickets(price);
        output.printLottoTickets(tickets);
        output.printResult(controller.judge(controller.winningNumbers().getNumbers(),controller.getBonusNumber().getBonus(), tickets));

    }
}
