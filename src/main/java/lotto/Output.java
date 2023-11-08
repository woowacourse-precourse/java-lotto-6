package lotto;

import java.util.List;
import lotto.domain.MyLotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.view.OutputView;

public class Output {
    private final OutputView outputView;
    private final MyLotto myLotto;
    private final int quantity;

    public Output(int quantity) {
        this.quantity = quantity;
        this.outputView = new OutputView();
        this.myLotto = new MyLotto(quantity);
    }

    public void generatedMyLottos() {
        List<List<Integer>> myLottoNumbers = myLotto.getMyLottoNumbersWithSorting() ;

        outputView.printLotto(quantity, myLottoNumbers);
    }

    public void statisticsAndProfitability(WinningLotto winningLotto) {
        List<Integer> statistics = myLotto.getStatistics(winningLotto);
        Result result = new Result(statistics);
        double profitability = result.getProfitability(quantity);

        outputView.printStatistics(statistics);
        outputView.printProfitability(profitability);
    }
}
