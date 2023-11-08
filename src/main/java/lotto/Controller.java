package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.service.InputService;
import lotto.service.OutputService;

public class Controller {

private InputService inputService;
private OutputService outputService;
private Customer customer;

public Controller() {
    inputService = new InputService();
    outputService = new OutputService();
}

public void run() {
    int money = inputService.readMoney();
    customer = new Customer(money);
    customer.buyLotto();

    outputService.printLottos(customer.getLottos());

    Lotto answer = inputService.readAnswer();
    int bonus = inputService.readBonus(answer);
    int[] placeCount = customer.getPlaceCount(answer, bonus);
    double ROI = customer.getROI(answer, bonus);

    outputService.printResult(placeCount, ROI);
}
}
