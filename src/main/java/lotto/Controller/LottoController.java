package lotto.Controller;

import java.util.List;
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

        int bonusNumber = inputView.getBonusNumber();

        outputView.printAllTickets(tickets);

        printResult(tickets,winTicket,bonusNumber,money);
    }


    public List<Lotto> buyTicket(int money){
        int ticketCount = lottoPurchaseMoney.getTicketCount(money);
        return lottoGenerator.makeTickets(ticketCount);
    }

    public Lotto getWinNumber(){
        return new Lotto(inputView.getWinNumbers());
    }
    public int calculateReword(List<Lotto> tickets, Lotto winTicket, int bonusNumber){
        int totalReward = 0;
        for (int i = 0; i < tickets.size() ; i++) {
            totalReward = rewardChecker.checkReward(tickets.get(i), winTicket, bonusNumber);
        }
        return totalReward;
    }

    public void printResult(List<Lotto> tickets, Lotto winTicket, int bonusNumber, int money){
        int totalReward = calculateReword(tickets, winTicket, bonusNumber);
        int[] rankCount = rewardChecker.getRankCount();

        double profitability = rewardChecker.calculateProfitability(totalReward, money);
        outputView.printRankResult(rankCount, profitability);
    }

}
