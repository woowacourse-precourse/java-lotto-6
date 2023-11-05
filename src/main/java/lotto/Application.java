package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MyLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        StringConverter stringConverter = new StringConverter();

        MyLotto myLotto = new MyLotto(inputView.inputBuyingCost());
        myLotto.printGenerateLottoResult();

        List<Integer> winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
        int bonusNumber = inputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        myLotto.checkResult(winningLotto);
    }
}
