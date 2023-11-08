package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoInfoNumbers;
import lotto.domain.LottoManager;
import lotto.domain.LottoValidation;
import lotto.domain.User;
import lotto.domain.Utils;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoManager lottoManager = new LottoManager();
    private User user;
    private LottoValidation lottoValidation;

    public void run() {
        user = new User(getPurchaseAmount());
        lottoManager.purchaseLotto(user);
        printPurchasedResult();

        lottoValidation = new LottoValidation(getWinningNumbers(), getBonusNumber());

        lottoManager.checkUserLotto(user, lottoValidation);
        System.out.println(OutputView.STATISTICS_HEADER);
        OutputView.printAllRankResult(user.getLottoResult());
        System.out.printf(OutputView.LOTTO_RETURNS, user.getLotteryReturns());
    }

    private int getPurchaseAmount() {
        System.out.println(InputView.INPUT_PURCHASE_AMOUNT);
        String userInput = Console.readLine().trim();
        return Utils.stringToInteger(userInput);
    }

    private List<Integer> getWinningNumbers() {
        System.out.println(InputView.INPUT_WINNING_NUMBERS);
        String winningNumbers = Console.readLine().trim();
        return Utils.stringToIntegerList(winningNumbers);
    }

    private int getBonusNumber() {
        System.out.println(InputView.INPUT_BONUS_NUMBERS);
        String bonusNumbers = Console.readLine().trim();
        return Utils.stringToInteger(bonusNumbers);
    }

    private void printPurchasedResult() {
        int count = user.getPurchaseAmount() / LottoInfoNumbers.LOTTERY_TICKET_PRICE;
        System.out.printf(OutputView.PURCHASE_COMPLETION, count);
        for (Lotto lotto : user.getPurchasedLotto()) {
            OutputView.lottoNumbers(lotto.getNumbers());
        }
    }
}
