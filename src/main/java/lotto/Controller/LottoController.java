package lotto.Controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.RewardChecker;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPurchaseMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final RewardChecker rewardChecker ;
    private LottoPurchaseMoney lottoPurchaseMoney;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = new LottoGenerator();
        this.rewardChecker = new RewardChecker();
    }

    public void start(){
        lottoPurchaseMoney = inputView.inputMoney();
        List<Lotto> tickets = buyTicket();

        outputView.printAllTickets(tickets);

        Lotto winTicket = getWinNumber();

        BonusNumber bonusNumber = inputView.getBonusNumber();

        calculateReward(tickets, winTicket, bonusNumber);
        printResult(lottoPurchaseMoney.getMoney());
    }


    public List<Lotto> buyTicket(){
        int ticketCount = lottoPurchaseMoney.getTicketCount();
        return lottoGenerator.makeTickets(ticketCount);
    }

    public Lotto getWinNumber(){
        return inputView.inputWinNumbers();
    }
    public void calculateReward(List<Lotto> tickets, Lotto winTicket, BonusNumber bonusNumber){
        for (int i = 0; i < tickets.size() ; i++) {
            rewardChecker.makeReward(tickets.get(i), winTicket, bonusNumber.getBonusNumber());
        }
    }

    public void printResult(int money){
        int[] rankCount = rewardChecker.getRankCount();
        double profitability = rewardChecker.calculateProfitability(rewardChecker.getTotalRewardAmount(), money);
        outputView.printRankResult(rankCount, profitability);
    }
}
