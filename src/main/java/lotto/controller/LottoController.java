package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private Money money;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public void start() {
        buyLottos();
        getWinnerNumbers();
        getBonusNumber();
    }

    private void buyLottos() {
        payMoney();
        generateLottos();
    }

    private void payMoney() {
        try {
            money = new Money(Input.inputMoney());
            Output.printLottosCount(money);
        } catch (IllegalArgumentException e) {
            payMoney();
        }
    }

    private void generateLottos() {
        lottos = new ArrayList<>();
        for(int i = 0 ; i < money.getCount() ; i++) {
            Lotto lotto = LottoGenerator.generateLotto();
            lottos.add(lotto);
            Output.printLottos(lotto);
        }
    }

    private void getWinnerNumbers() {
        try {
            winningNumbers = new Lotto(Input.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            getWinnerNumbers();
        }
    }

    private void getBonusNumber() {
        bonusNumber = new BonusNumber(Input.inputBonusNumber());
        try {
            winningNumbers.validateBonusNumber(bonusNumber);
        } catch(IllegalArgumentException e) {
            getBonusNumber();
        }
    }
}
