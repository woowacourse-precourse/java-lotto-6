package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.JackpotNumber;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.service.DecideAward;
import lotto.service.UserLottoService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.JackpotNumberException;
import lotto.service.UserBillToAmount;
import lotto.service.ProfitCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Controller {
    public static void run() {
        User user = UserSetting();
        JackpotNumber jackpotNumber = JackpotNumberSetting();
        LotteryResult(user, jackpotNumber);
    }

    private static User UserSetting() {
        int amount = UserAmountSetting();
        User user = UserLottoService.lottoSetting(amount);
        OutputView.printUserLotto(user);
        return user;
    }

    private static JackpotNumber JackpotNumberSetting() {
        JackpotNumber jackpotNumber = JackpotSetting();
        jackpotNumber = BonusNumberSetting(jackpotNumber);
        return jackpotNumber;

    }
    private static void LotteryResult(User user, JackpotNumber jackpotNumber) {
        Result result = clacLotteryResult(user, jackpotNumber);
        OutputView.printResult(result);
        OutputView.printProfitRate(ProfitCalculator.calcProfitRate(user, result));
    }
    private static Result clacLotteryResult(User user, JackpotNumber jackpotNumber) {
        Result result = null;
        result = DecideAward.userResult(user, jackpotNumber);
        return result;
    }
    private static int UserAmountSetting() {
        int amount = 0;
        try {
            amount = UserBillToAmount.billToAmount(InputView.requestAmount());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            amount = UserAmountSetting();
        }
        return amount;
    }
    private static JackpotNumber JackpotSetting() {
        JackpotNumber jackpotNumber = null;
        try {
            String jackpot = InputView.requestJackpotNumber();
            List<Integer> jackpotIntList = Arrays.stream(jackpot.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            //jackpotNumber = new JackpotNumber(new Lotto(jackpotIntList), 100);
            jackpotNumber = new JackpotNumber(new Lotto(jackpotIntList));
            JackpotNumberException.isJackpotValid(jackpotNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            jackpotNumber= JackpotSetting();
        }
        return jackpotNumber;
    }
    private static JackpotNumber BonusNumberSetting(JackpotNumber jackpotNumber) {
        try {
            String bonusNumber = InputView.requestBonusNumber();
            jackpotNumber.changeBonus(Integer.parseInt(bonusNumber));
            JackpotNumberException.isBonusValid(jackpotNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            jackpotNumber = BonusNumberSetting(jackpotNumber);
        }
        return jackpotNumber;
    }

}
