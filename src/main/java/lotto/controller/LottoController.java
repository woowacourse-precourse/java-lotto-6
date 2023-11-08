package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.PrizeLotto;
import lotto.model.PrizeMoney;
import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidator numberValidator = new NumberValidator();
    PrizeController prizeController = new PrizeController();
    UserLotto userLotto = new UserLotto();
    Lotto lotto;
    PrizeLotto prizeLotto;

    public void proceedLotto() {
        createUserLottoNum();
        outputView.printNumberOfBuyLotto(userLotto.getBuyMoney() / 1000);
        outputView.printLottoNums(userLotto.getUsersLotto());

        prizeLotto = createPrizeNum();

        prizeController.comparePrizeNumToLottoNum(prizeLotto, userLotto);
        prizeController.createLottoRankStore();
        prizeController.calculateLottoPrize();
        System.out.println("상금: " + prizeController.winnerLotto.getPrizeSumMoney());
        System.out.println("수익률:" + prizeController.rateOfReturn(userLotto.getBuyMoney()));

        outputView.printWinnerStatistcs(prizeController.winnerLotto.getLottoPrizeCount(), prizeController.rateOfReturn(userLotto.getBuyMoney()));


    }

    public PrizeLotto createPrizeNum() {
        List<Integer> lo;
        int bonus;
        lo = lottoNumCheck
                ();
        bonus = lottoBonusNumCheck(lo);
        return new PrizeLotto(lo, bonus);

    }

    public List<Integer> lottoNumCheck() {
        List<Integer> lo;
        while (true) {
            try {
                lo = numberValidator.prizeLottoNumValidator(inputView.enterPrizeLottoNum());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lo;
    }

    public int lottoBonusNumCheck(List<Integer> lo) {
        int bonus;
        while (true) {
            try {
                bonus = numberValidator.lottoBonusNumValidator(inputView.enterBonusNum(), lo);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    public void createUserLottoNum() {
        while (true) {
            try {
                int buyLottoNum = numberValidator.buyLottoMoneyValidator(inputView.enterBuyLottoAmount());
                List<Lotto> lotto = generateLottoNum(buyLottoNum);
                userLotto.setBuyMoney(1000 * buyLottoNum);
                userLotto.setUsersLotto(lotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottoNum(int num) {
        List<Lotto> lotto = new ArrayList<Lotto>(num);
        for (int i = 0; i < num; i++) {
            Lotto lotto1 = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.add(lotto1);
        }
        return lotto;
    }
}
