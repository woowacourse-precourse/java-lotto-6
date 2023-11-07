package lotto.service;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoResult;
import lotto.domain.lotto.WinningLotto;
import lotto.util.Generator;

public class LottoService {
    private final LottoMachine lottoMachine;
    private final Generator generator;
    private WinningLotto winningLotto;
    private Customer customer;

    public LottoService(LottoMachine lottoMachine, Generator generator) {
        this.lottoMachine = lottoMachine;
        this.generator = generator;
    }

    public void issueLotto(final Customer customer, final int quantity) {
        this.customer = customer;

        for (int count = 0; count < quantity; count++) {
            Lotto issuedLotto = lottoMachine.issueLotto(generator);
            customer.buyLotto(issuedLotto);
        }
    }

    public void saveWinningLotto(final List<Integer> winningNumber, final int bonusNumber) {
        winningLotto = new WinningLotto(new Lotto(winningNumber), new Bonus(bonusNumber));
    }

    public ResultDto getResult() {
        LottoResult lottoResult = new LottoResult(winningLotto, customer.getIssuedLottos());
        ResultDto resultDto = new ResultDto(lottoResult);
        return resultDto;
    }
}
