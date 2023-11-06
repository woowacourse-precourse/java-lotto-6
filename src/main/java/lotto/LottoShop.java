package lotto;

import static lotto.view.InputView.inputMoney;
import static lotto.view.OutputView.println;

import java.util.List;
import lotto.view.OutputView;

public class LottoShop {
    private static final String INPUT_PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요.";
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> buyLotto() {
        println(INPUT_PURCHASE_AMOUNT_COMMENT);
        LottoAmount lottoAmount = new LottoAmount(inputMoney());

        List<Lotto> lottoList = lottoMachine.buyLottos(lottoAmount.getAmount());
        notifyLottoList(lottoList);

        return lottoList;
    }

    private void notifyLottoList(List<Lotto> lottoList) {
        OutputView.printLottoList(lottoList);
    }
}
