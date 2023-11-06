package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.Money;
import lotto.configuration.InputMessage;
import lotto.configuration.PrintMessage;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private static final Integer ONE_THOUSAND = 1000;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void startLotto() {
        Long money = inputPurchaseAmount();
    }

    private Long inputPurchaseAmount() {
        InputMessage.INPUT_PURCHASE_AMOUNT.inputMessage();
        Long myMoney = Long.parseLong(InputView.input());
        Money money = new Money(myMoney);
        return money.getMoney();
    }

    private List<List<Integer>> buyLotto(Long money) {
        PrintMessage.BUY_LOTTO_COUNT.printMessage(money/ONE_THOUSAND);
        List<List<Integer>> myLotto = lottoService.generateRandomLottoNumbers(money/ONE_THOUSAND);
        for (int i = 0; i < money/ONE_THOUSAND; i++) {
            OutputView.lottoNumbersResult(myLotto.get(i));
        }

        return myLotto;
    }

    private List<Integer> inputWinningLottoNumber(Long money) {
        OutputView.inputViewWinningNumber();
        Lotto lotto = new Lotto(lottoService.convertToLottoIntegerList(InputView.input()));
        return lotto.getLotto();
    }

    private Integer inputBonusNumber() {
        OutputView.inputViewBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(InputView.input()));
        return bonusNumber.getBonusNumber();
    }
}
