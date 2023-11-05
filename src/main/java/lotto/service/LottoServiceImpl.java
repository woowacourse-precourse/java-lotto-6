package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Cost;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoServiceImpl implements LottoService{
    private static final int START = 0;

    @Override
    public List<List<Integer>> buyLotto() {
        int quantity = payMoney();
        List<List<Integer>> myLottos = getMyLotto(quantity);

        OutputView outputView = new OutputView();
        outputView.printLotto(quantity, myLottos);

        return myLottos;
    }

    private int payMoney() {
        InputView inputView = new InputView();
        Cost cost = new Cost(inputView.inputBuyingCost());

        return cost.getQuantity();
    }

    private List<List<Integer>> getMyLotto(int quantity){
        return IntStream.range(START, quantity)
                .mapToObj(q -> generateLottoNumber())
                .toList();
    }
    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

}
