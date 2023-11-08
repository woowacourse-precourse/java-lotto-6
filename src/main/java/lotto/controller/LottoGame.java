package lotto.controller;

import static lotto.domain.User.DIVIDE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private long purchaseAmount;
    private InputView inputView;
    private OutputView outputView;
    private User user;

    private LottoService lottoService;

    public LottoGame(InputView inputView, OutputView outputView, User user, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.user = user;
        this.lottoService = lottoService;
    }

    public void start() {
        purchaseAmount();
        makeLotto();
        winningNumber();
        bonusNumber();
        winningResult();
    }

    private void winningResult() {
        Map<Integer, Integer> result = new HashMap<>();
        double rate;
        outputView.winningResult();
        result = lottoService.compareValue(lottos, user);
        outputView.result(result);
        rate = lottoService.getRate(result, user);
        outputView.rate(rate);
    }

    private void bonusNumber() {
        outputView.bonusNumber();
        while (true) {
            String input = inputView.readLine();
            try {
                user.setBonusNumber(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void winningNumber() {
        outputView.winnerNumber();
        while (true) {
            String input = inputView.readLine();
            try {
                user.setWinnerNumbers(input);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void makeLotto() {
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        outputView.printLotto(lottos);
    }

    private void purchaseAmount() {
        outputView.purchaseAmount();
        while (true) {
            String input = inputView.readLine();
            try {
                user.setPurchaseAmount(input);
                purchaseAmount = user.getPurchaseAmount() / DIVIDE_NUMBER;
                outputView.printPurchaseAmount(purchaseAmount);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
