package lotto;

import lotto.controller.Controller;
import lotto.model.ValidValues;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        ValidValues validValues = new ValidValues();
        Output output = new Output();

        Controller controller = new Controller(input, validValues);
        int price = controller.getPurchasePrice().price;
        output.printLottoTickets(controller.generateLottoTickets(price));
        controller.winningNumbers();
        controller.getBonusNumber();

//여기에서 아웃풋에 컨트롤러 결과 넣어주기

    }
}
