package lotto.lottoGame;

import lotto.customer.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoRandomGenerator lottoRandomGenerator;

    public LottoGame(LottoRandomGenerator lottoRandomGenerator) {
        this.lottoRandomGenerator = lottoRandomGenerator;
    }

    private Customer initCustomer() {
        String inputPurchaseValue = InputView.inputPrice();
        return new Customer(inputPurchaseValue);
    }

    public void run() {
        Customer customer = initCustomer();
        issuanceLottos(customer);
    }

    private void issuanceLottos(Customer customer) {
        int index = customer.getPurchaseValue() / 1000;
        while (customer.getLottoSize() < index) {
            customer.buy(lottoRandomGenerator.generateLottoSortedNumbers());
        }

        OutputView.outputIssuance(index, customer.getLottos());
    }
}
