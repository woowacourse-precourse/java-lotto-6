package lotto.Controller;

import lotto.Constant.LottoConstant;
import lotto.Lottery;
import lotto.Service.LottoService;
import lotto.ServiceImp.LottoServiceImp;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController()
    {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoServiceImp();
    }

    public void simulateLottery()
    {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = inputView.getCost();

        System.out.println(lottoService.getNumberOfLotto() + "개를 구매했습니다.");
        outputView.printLotto(lottoService.getLotto());
    }
}
