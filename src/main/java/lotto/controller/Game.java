package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.LottoPurchaseInfo;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    public Game() {

    }

    public void play() {

        int purchaseAmount = InputView.inputPurchaseAmount();
        int purchaseLottoNum = purchaseAmount / 1000;

        LottoPurchaseInfo lottoPurchaseInfo = new LottoPurchaseInfo(purchaseAmount, purchaseLottoNum);
        OutputView.outputPurchaseCount(lottoPurchaseInfo.getPurchaseLottoNum());
        OutputView.outputPurchaseLottos(lottoPurchaseInfo.getLottos());

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningNum());
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = Integer.parseInt(readLine());
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("번호는 1~45사이 값이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }
    }
}
