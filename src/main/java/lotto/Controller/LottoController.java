package lotto.Controller;

import lotto.Constant.LottoConstant;
import lotto.Lottery;
import lotto.Lotto;
import lotto.Service.LottoService;
import lotto.ServiceImp.LottoServiceImp;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

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

        lottoService.initializeLottery(cost);
        System.out.println(lottoService.getNumberOfLotto() + "개를 구매했습니다.");
        outputView.printLotto(lottoService.getLotto());

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotteryNumber = inputView.getWinningLotteryNumber();
        System.out.println("보너스 번호를 입력해주세요");
        int bonusWinningLotteryNumber = inputView.getBonusWinningLotteryNumber(winningLotteryNumber);

        List<Integer> resultRecord = lottoService.getResultRecordOfLotto(winningLotteryNumber, bonusWinningLotteryNumber);
        outputView.printResultRecord(resultRecord);
        System.out.println("총 수익률은 " + Double.toString(lottoService.getProfitRate(resultRecord)) + "%입니다.");
    }
}
