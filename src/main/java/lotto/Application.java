package lotto;

import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        StringConverter stringConverter = new StringConverter();
        Cost cost = new Cost(inputView.inputBuyingCost());

        LottoShop lottoShop = new LottoShop(cost);
        lottoShop.receiveMyLottos();

        List<Integer> winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        lottoShop.checkResult(winningLotto);
    }
}
