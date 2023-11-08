package lotto.controller;

import lotto.domain.Customer;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Customer customer;
    private LottoService lottoService;
    private InputView inputView=new InputView();
    private OutputView outputView=new OutputView();

    public void buyLotto(){
        customer=new Customer(inputView.inputMoney());
        customer.pay();
        outputView.printCount(customer.getLottos().size());
        showLottoList();
    }

    private void showLottoList(){
        customer.getLottos().stream()
                .forEach(lotto->outputView.printLotto(lotto));
    }
}
