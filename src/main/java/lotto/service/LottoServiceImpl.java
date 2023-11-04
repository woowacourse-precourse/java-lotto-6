package lotto.service;

import java.util.List;
import lotto.domain.Cost;
import lotto.domain.MyLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoServiceImpl implements LottoService{
    @Override
    public List<List<Integer>> buyLotto() {
        int cost = payMoney();
        List<List<Integer>> myLottos = getMyLotto(cost);

        return myLottos;
    }

    private int payMoney() {
        InputView inputView = new InputView();
        Cost cost = new Cost(inputView.inputBuyingCost());

        return cost.getCost();
    }

    private List<List<Integer>> getMyLotto(int cost){
        MyLotto myLotto = new MyLotto(cost);
        int quantity = myLotto.getQuantity();

        List<List<Integer>> myLottos = myLotto.getMyLottos();

        OutputView outputView = new OutputView();
        outputView.printLotto(quantity, myLottos);

        return myLottos;
    }
}
