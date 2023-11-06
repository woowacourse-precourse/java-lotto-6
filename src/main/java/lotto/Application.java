package lotto;

import lotto.domain.BuyLotto;
import lotto.domain.InputNumber;
import lotto.domain.ResultLotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        buyLotto.inputMoney();

        List<Integer> lottoNumbersPurchased;
        lottoNumbersPurchased = buyLotto.numberLotto();

        InputNumber inputNumber = new InputNumber();
        List<Integer> winningNumber = inputNumber.inputWinningNumber();
        int bonusNumber = inputNumber.inputBonusNumber();

        ResultLotto resultLotto = new ResultLotto();
        resultLotto.showDetail(lottoNumbersPurchased, winningNumber, bonusNumber);
    }
}
