package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.randomNumbersLotto;
import lotto.view.inputView;
import lotto.view.outputView;

public class Controller {

    public void tempInputOutputController() {

        inputView inputView = new inputView();
        outputView outputView = new outputView();
        randomNumbersLotto randomNumbersLotto = new randomNumbersLotto();
        List<List<Integer>> outputRandomLottoNumber = new ArrayList<>();
        String inputMoney = inputView.howMuchBuyLotto();
        // checkException(inputMoney)

        int amountLottos = Integer.getInteger(inputMoney) / 1000;
        outputView.outputAmountOfLotto(amountLottos);

        for (int i = 0; i < amountLottos; i++) {
            List<Integer> lottosRandomNumbers = randomNumbersLotto.makeRandomNumLottos();
            outputRandomLottoNumber.add(lottosRandomNumbers);
        }
        outputView.outputLottosNumbers(outputRandomLottoNumber);

        String userInPut = inputView.inputWinningNumber();
        System.out.println();
        String bonusNum = inputView.inputBonusNumber();
        System.out.println();




    }

}
