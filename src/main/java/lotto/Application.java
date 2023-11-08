package lotto;

import lotto.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseQuantity = Purchase.inputMoney();
        int lottoQuantity = Purchase.calculateQuantity(purchaseQuantity);
        List<Lotto> purchasedLotto = LottoGenerator.generateLotto(lottoQuantity);

        List<Integer> winningNumber = BallNumber.transWinningBall(BallNumber.inputWinningBall());
        int bonusBall = BallNumber.inputBonusBall();

        Result result = new Result(purchasedLotto, winningNumber, bonusBall);
        result.printResult();
    }
}
