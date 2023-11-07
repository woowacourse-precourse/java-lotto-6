package lotto;

import lotto.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        int purchaseLottoMoney = buyLotto.inputMoney();

        List<Integer> lottoNumbersPurchased;
        lottoNumbersPurchased = buyLotto.numberLotto();

        InputNumber inputNumber = new InputNumber();
        List<Integer> winningNumber = inputNumber.inputWinningNumber();
        int bonusNumber = inputNumber.inputBonusNumber();

        ResultLotto resultLotto = new ResultLotto();
        List<Prize> prizeList = resultLotto.showDetail(lottoNumbersPurchased, winningNumber, bonusNumber);

        Revenue.rateOfRevenue(prizeList, purchaseLottoMoney);
    }
}
