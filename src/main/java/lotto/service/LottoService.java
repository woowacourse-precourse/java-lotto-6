package lotto.service;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.RandomNumberGenerator;

public class LottoService {
    private LottoMachine lottoMachine = new LottoMachine();
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private WinningLotto winningLotto;
    private Customer customer;

    public LottoService() {

    }

    public void issueLotto(Customer customer, int quantity) {
        this.customer = customer;
        for (int count = 0; count < quantity; count++) {
            Lotto issuedLotto = lottoMachine.issueLotto(randomNumberGenerator);
            customer.buyLotto(issuedLotto);
        }
    }

    public void saveWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        winningLotto = new WinningLotto(new Lotto(winningNumber), new Bonus(bonusNumber));
    }

    public ResultDto getResult() {
        LottoResult lottoResult = new LottoResult(winningLotto, customer.getIssuedLottos());
        ResultDto resultDto = new ResultDto(lottoResult);
        return resultDto;
    }
}
