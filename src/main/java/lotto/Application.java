package lotto;


import java.util.List;
import lottomachine.LottoAmountCalculator;
import lottomachine.Lotto;
import lottomachine.LottoChecker;
import lottomachine.LottoGenerator;
import lottomachine.LottoStatistics;
import lottomachine.WinningLotto;
import service.Inputter;
import service.Outputter;
import user.LottoTickets;
import user.Money;
import user.TotalResult;

public class Application {
    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Outputter outputter = new Outputter();
        Money money = new Money();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoAmountCalculator lottoAmountCalculator = new LottoAmountCalculator();
        WinningLotto winningLotto = new WinningLotto();

        List<Lotto> lottoList;

        money.requestMoney(inputter);
        int userMoney = money.getMoney();
        int userLottoAmount = lottoAmountCalculator.getLottoAmount(userMoney);

        outputter.promptLottoAmount(userLottoAmount);

        lottoList = lottoGenerator.generateLotto(userLottoAmount);
        LottoTickets lottoTickets = new LottoTickets(lottoList);

        outputter.promptLottoList(lottoList);

        outputter.promptWiningTicketNumbers();
        Lotto winningNumber = winningLotto.requestWinningLottoNumbers(inputter);


        int bonusNumber = winningLotto.requestBonusNumber(inputter, winningNumber);

        LottoChecker lottoChecker = new LottoChecker(lottoList, winningNumber, bonusNumber);
        TotalResult totalResult = new TotalResult(lottoChecker.checkLottos());
        LottoStatistics lottoStatistics = new LottoStatistics(totalResult.getTotalResult());
        lottoStatistics.printStatistics();
    }
}
