package lotto;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.LottoMachine;
import lotto.model.LottoResultChecker;
import lotto.model.Ranking;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        //1. 구입 가격을 입력받는다.
        InputView inputView = new InputView();
        int answer = inputView.requestPrice();

        //2. 로또 구매 개수를 출력한다.
        OutputView outputView = new OutputView();
        int boughtLotto = outputView.printPurchases(answer);

        //3. 갯수만큼 로또 번호를 출력한다.
        LottoMachine lottoMachine = new LottoMachine(boughtLotto);
        lottoMachine.issueTickets();
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());

        //4. 당첨 번호를 입력받는다.
        String winningNumbers = inputView.requestWinningNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers);

        //5. 보너스 번호를 입력받는다.
        int bonusNumber = inputView.requestBonusNumber();
        winningLotto.addBonus(new Bonus(bonusNumber));

        LottoResultChecker checker =
            new LottoResultChecker(lottoMachine.getIssuedLotto(), winningLotto);

        //발행된 각각의 로또에 대한 랭킹이 담긴 리스트
        List<Ranking> rankings = checker.checkResult();
        Statistics statistics = new Statistics();
        statistics.makeResultBoard();
        statistics.createData(rankings);

        //당첨 통계를 각각 출력한다.
        outputView.printLotteryStatistics();
        outputView.printStatisticsResult(statistics.getResults());

        float revenue = statistics.getRateOfReturn();
        float result = (revenue / answer) * 100 ;

        outputView.printRateOfReturn(result);
    }
}
