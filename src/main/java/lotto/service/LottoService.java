package lotto.service;

import java.util.List;
import lotto.domain.Cashier;
import lotto.domain.Customer;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.WinningLotto;
import lotto.util.Generator;

public class LottoService {
    private static final int START = 0;
    private final Cashier cashier;
    private final LottoMachine lottoMachine;
    private final Generator generator;
    private WinningLotto winningLotto;
    private Customer customer;

    public LottoService(Cashier cashier, LottoMachine lottoMachine, Generator generator) {
        this.cashier = cashier;
        this.lottoMachine = lottoMachine;
        this.generator = generator;
    }

    public int calculateLotto(final int money) {
        customer = new Customer(money);
        return cashier.calculateMoney(customer.getMoney());
    }

    public LottoDto issueLotto(final int quantity) {
        for (int count = START; count < quantity; count++) {
            Lotto issuedLotto = lottoMachine.issueLotto(generator);
            customer.buyLotto(issuedLotto);
        }
        return LottoDto.from(customer);
    }

    public void saveWinningLotto(final List<Integer> winningNumber, final int bonusNumber) {
        winningLotto = new WinningLotto(new Lotto(winningNumber), new Bonus(bonusNumber));
    }

    public ResultDto getResult() {
        LottoResult lottoResult = new LottoResult(winningLotto, customer.getIssuedLottos());
        ResultDto resultDto = ResultDto.from(lottoResult);
        return resultDto;
    }
}
