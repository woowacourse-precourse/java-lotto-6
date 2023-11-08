package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseQuantity = Purchase.inputMoney();
        int lottoQuantity = Purchase.calculateQuantity(purchaseQuantity);
        List<Lotto> purchasedLotto = LottoGenerator.generateLotto(lottoQuantity);


        List<Integer> winningNumber = new ArrayList<>();

        while (BallNumber.canUse) {
            winningNumber = BallNumber.transWinningBall(BallNumber.inputWinningBall());
            BallNumber.canUse = BallNumber.validate(winningNumber);
        }

        BallNumber.canUse = true;
        int bonusBall = 0;
        while (BallNumber.bonusBallCanUse) {
            bonusBall = BallNumber.inputBonusBall();
            BallNumber.bonusBallCanUse = BallNumber.checkBonusBall(winningNumber, bonusBall);
        }

        Result result = new Result(purchasedLotto, winningNumber, bonusBall);
        result.printResult();
    }
}
