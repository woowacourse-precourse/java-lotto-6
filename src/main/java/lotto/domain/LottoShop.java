package lotto.domain;

import java.util.List;
import lotto.view.OutputView;

public class LottoShop {
    private final Cost cost;
    private final MyLotto myLotto;
    public LottoShop(Cost cost) {
        this.cost = cost;
        this.myLotto = new MyLotto(cost.getQuantity());
    }

    public List<List<Integer>> receiveMyLottos() {
        OutputView outputView = new OutputView();
        outputView.printLotto(cost.getQuantity(), myLotto.getMyLottoNumbers());

        return myLotto.getMyLottoNumbers();
    }

    public void checkResult(WinningLotto winningLotto) {
        OutputView outputView = new OutputView();
        Result result = new Result(winningLotto, myLotto);

        List<Integer> statistics = result.getStatistics();
        float profitability = result.getProfitability(cost.getQuantity());

        outputView.printStatistics(statistics);
        outputView.printProfitability(profitability);
    }
}
