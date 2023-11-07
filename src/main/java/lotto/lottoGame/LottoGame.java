package lotto.lottoGame;

import lotto.Lotto;
import lotto.WinningLotto;
import lotto.customer.Customer;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final LottoRandomGenerator lottoRandomGenerator;
    private final LottoInputGenerator lottoInputGenerator;

    public LottoGame(LottoRandomGenerator lottoRandomGenerator, LottoInputGenerator lottoInputGenerator) {
        this.lottoRandomGenerator = lottoRandomGenerator;
        this.lottoInputGenerator = lottoInputGenerator;
    }

    private Customer initCustomer() {
        String inputPurchaseValue = InputView.inputPrice();
        return new Customer(inputPurchaseValue);
    }

    private WinningLotto initWinningLotto() {
        String inputWinningNumbers = InputView.inputWinningLottoNumber();
        Lotto winningNumbers = lottoInputGenerator.inputNumbersToLotto(inputWinningNumbers);

        String inputBonusNumber = InputView.inputWinningBonusNumber();
        int validatedBonusNumber = lottoInputGenerator.inputBonusToValidatedValue(inputBonusNumber);

        return new WinningLotto(winningNumbers, validatedBonusNumber);
    }

    public void run() {
        Customer customer = initCustomer();
        issuanceLottos(customer);

        WinningLotto winningLotto = initWinningLotto();

    }


    private void issuanceLottos(Customer customer) {
        int index = customer.getPurchaseValue() / 1000;
        while (customer.getLottoSize() < index) {
            customer.buy(lottoRandomGenerator.generateLottoSortedNumbers());
        }

        OutputView.outputIssuance(index, customer.getLottos());
    }
}
