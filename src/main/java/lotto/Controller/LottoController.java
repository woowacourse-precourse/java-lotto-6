package lotto.Controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.LongToDoubleFunction;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        int money = inputView.getMoney();

        Lotto winTicket = new Lotto(inputView.getWinNumbers());
        int bonusNumber = inputView.getBonusNumber();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> tickets = lottoGenerator.getTickets(money);

        outputView.printAllTickets(tickets);

        LottoChecker lottoChecker = new LottoChecker();
        int totalReward = 0;
        for (int i = 0; i < tickets.size() ; i++) {
            totalReward = lottoChecker.checkReward(tickets.get(i), winTicket, bonusNumber);
        }

        int[] rankCount = lottoChecker.getRankCount();

        DecimalFormat df = new DecimalFormat("#.##"); // 소수점 둘째 자리까지 표시
        double profitability = ((double) totalReward / money) * 100;

        outputView.printRankResult(rankCount, profitability);

    }

}
