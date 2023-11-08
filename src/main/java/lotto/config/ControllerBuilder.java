package lotto.config;

import java.util.Collection;
import lotto.Controller;
import lotto.InputInterface;
import lotto.OutputInterface;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryRanking;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LotteryRound;
import lotto.domain.LottoRandom;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.CalculateResultService;
import lotto.service.PurchaseLotteryService;
import lotto.service.UserService;

public class ControllerBuilder {

    private InputInterface in;
    private OutputInterface out;
    private CalculateResultService calculateResultService;
    private UserService userService;
    private ApplyWinningLotteryService applyWinningLotteryService;
    private PurchaseLotteryService purchaseLotteryService;
    private String username;
    private LotteryOperator operator;


    public ControllerBuilder setOperator(LotteryRound round, Collection<? extends LotteryRanking> rankings) {
        if (operator == null) {
            operator = new LotteryOperator(round, rankings, 1000);
        }
        return this;
    }

    public ControllerBuilder setUserService(String username) {
        if (userService == null) {
            userService = new UserService();
            userService.register(username);
            this.username = username;
        }
        return this;
    }

    public ControllerBuilder setPurchaseLotteryService(LottoRandom random) {
        assert (operator != null) && (userService != null);

        if (purchaseLotteryService == null) {
            purchaseLotteryService = new PurchaseLotteryService(new LotteryRetailer(random), operator, userService);
        }
        return this;
    }

    public ControllerBuilder setInputInterface(InputInterface input) {
        if (in == null) {
            this.in = input;
        }
        return this;
    }

    public ControllerBuilder setOutputInterface(OutputInterface output) {
        if (out == null) {
            this.out = output;
        }
        return this;
    }

    public Controller build() {
        assert (operator!=null);
        applyWinningLotteryService = new ApplyWinningLotteryService(operator);
        calculateResultService = new CalculateResultService(new LotteryResultsCalculator(operator), userService);
        return new Controller(in, out, username, purchaseLotteryService,
                applyWinningLotteryService, calculateResultService);
    }
}
