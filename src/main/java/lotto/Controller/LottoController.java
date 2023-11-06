package lotto.Controller;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchaseMoney;
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
        int ticketCount = getTickets(money);

        Lotto winTicket = new Lotto(inputView.getWinNumbers());
        int bonusNumber = inputView.getBonusNumber();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> tickets = lottoGenerator.makeTickets(ticketCount);

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
    public int getTickets(int money){
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney();
        return lottoPurchaseMoney.getTicketCount(money);
    }

}
