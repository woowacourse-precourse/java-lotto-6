package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Customer;
import service.LottoService;

public class LottoController {

    private static final LottoService lottoService = new LottoService();

    public void execute() {
        int LottoTimes = BuyLotto();



        lottoService.exectue();
    }

    private static int BuyLotto() {
        Customer customer = null;
        try {
            customer = new Customer();

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            BuyLotto();
        }
        return customer.getCount();
    }


}
