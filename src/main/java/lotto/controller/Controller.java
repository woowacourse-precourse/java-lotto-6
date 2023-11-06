package lotto.controller;

import lotto.model.*;
import lotto.view.Message;
import lotto.view.UserInput;
import lotto.view.UserOutput;

import java.util.HashMap;
import java.util.List;

public class Controller {
    public static void startGame() {
        User user = initializeLottoes();
        Winning winning = initializeWinning();

        checkLottoResult(user, winning);
        showLottoResult(user);
    }

    public static User initializeLottoes() {
        int money = getValidMoney();
        HashMap<Lotto, Rank> lottos = publishLotto(money);
        User user = new User(money, lottos);
        UserOutput.ConsolePrintBoughtResult(user);

        return user;
    }

    public static Winning initializeWinning() {
        List<Integer> winning_number = getValidWinningNumber();
        int bonusNumber = getValidBonusNumber(winning_number);

        return new Winning(new Lotto(winning_number), bonusNumber);
    }

    public static void showLottoResult(User user) {
        List<Integer> result = StaticsService.getWinningStatics(user.getLottos());
        UserOutput.ConsolePrintStatistics(result);
        double winning_rate = StaticsService.calculateReturnRate(result, user.getNumber() * Constant.LOTTO_PRICE);
        UserOutput.ConsolePrintStatResult(winning_rate);
    }

    public static int getValidBonusNumber(List<Integer> winning) {
        while (true) {
            try {
                String bonus = UserInput.ConsoleInputBonusNumber();
                return Convertor.convertBonus(bonus, winning);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getValidWinningNumber() {
        while (true) {
            try {
                String number = UserInput.ConsoleInputWinningNumber();
                return Convertor.convertNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public static int getValidMoney() {
        while (true) {
            try {
                String money = UserInput.ConsoleInputBoughtMoney();
                return Convertor.convertMoney(money);
            } catch (IllegalArgumentException e) {
                System.out.println(Message.ERROR_MONEY);
            }
        }
    }

    public static HashMap<Lotto, Rank> publishLotto(int money) {
        HashMap<Lotto, Rank> lottos = new HashMap<>();

        for (int i = 0; i < money / Constant.LOTTO_PRICE; i++) {
            Lotto lotto = new Lotto(LottoService.makeRandomLottoNumber());
            lottos.put(lotto, Rank.NONE);
        }

        return lottos;
    }

    public static void checkLottoResult(User user, Winning winning) {
        for (Lotto lotto : user.getLottos().keySet()) {
            Rank rank = LottoService.checkLottoRank(lotto, winning);
            user.setLottoResult(lotto, rank);
        }
    }
}
