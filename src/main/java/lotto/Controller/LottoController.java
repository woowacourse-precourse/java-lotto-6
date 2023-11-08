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
    private final LottoPurchaseMoney lottoPurchaseMoney;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = new LottoGenerator();
        this.rewardChecker = new RewardChecker();
        this.lottoPurchaseMoney = new LottoPurchaseMoney();
    }

    public void start(){
        int money = inputView.getMoney();
        List<Lotto> tickets = buyTicket(money);

        Lotto winTicket = getWinNumber();

        BonusNumber bonusNumber = new BonusNumber(inputView.getBonusNumber());

        outputView.printAllTickets(tickets);
        calculateReward(tickets, winTicket, bonusNumber);
        printResult(money);
    }


    public List<Lotto> buyTicket(int money){
        int ticketCount = lottoPurchaseMoney.getTicketCount(money);
        return lottoGenerator.makeTickets(ticketCount);
    }

    public Lotto getWinNumber(){
        return new Lotto(inputView.getWinNumbers());
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
