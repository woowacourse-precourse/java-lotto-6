package lotto.controller;

import static lotto.domain.User.DIVIDE_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private long purchaseAmount;
    private InputView inputView;
    private OutputView outputView;
    private User user;

    public LottoGame(InputView inputView, OutputView outputView, User user) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.user = user;
    }

    public void start() {
        purchaseAmount();
        makeLotto();
        winningNumber();
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
