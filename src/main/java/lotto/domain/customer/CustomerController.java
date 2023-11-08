package lotto.domain.customer;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.LottoController;
import lotto.view.View;

public class CustomerController {
    public static Customer customer;
    public CustomerService customerService;
    public LottoController lottoController;
    public View view;

    public CustomerController() {
        this.view = new View();
        view.askPrice();
        while (true) {
            try {
                this.customer = new Customer(Console.readLine());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        view.breakLine();

        customerService = new CustomerService(customer);
        lottoController = new LottoController(customer);
    }
}
