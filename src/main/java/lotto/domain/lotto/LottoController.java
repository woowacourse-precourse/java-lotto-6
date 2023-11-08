package lotto.domain.lotto;

import lotto.domain.customer.Customer;
import lotto.domain.winningnumber.WinningNumberController;
import lotto.view.View;

import java.util.List;

public class LottoController {
    public LottoService lottoService;
    public WinningNumberController winningNumberController;
    public View view;

    public LottoController(Customer customer) {
        lottoService = new LottoService(customer);
        List<Lotto> lottos = lottoService.drawLots();
        customer.setLottos(lottos);

        view = new View();
        view.notifyQuantityOfPurchase(customer.getQuantity());
        for (Lotto lotto : lottos) {
            view.notifyLottoNumbers(lotto.getNumbers());
        }
        view.breakLine();

        winningNumberController = new WinningNumberController();
    }
}
