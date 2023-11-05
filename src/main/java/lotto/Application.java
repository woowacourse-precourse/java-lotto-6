package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Computer;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.User;
import lotto.ui.Input;
import lotto.ui.Output;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        User user = new User();

        Output.printPurchase();
        user.purchaseLotto();

        // 4. 로또 번호 출력
        Output.printLottos(user.lottos);

        // 5. 당첨 번호 입력
        Output.printWinningNumber();
        Lotto winningLotto = LottoGenerator.createWinningLotto(Input.get());

        // 6. 보너스 번호 입력
        Output.printBonusNumber();
        Integer bonusNumber = LottoGenerator.createBonusNumber(winningLotto, Input.get());

        // 7. 당첨 내역 계산 로직
        List<Integer> lottoResult = Computer.checkWinning(user.lottos, winningLotto, bonusNumber);

        // 당첨금
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000));

        // 8. 수익률 계산 로직
        Double earningRate = Computer.calculateEarningRate(lottoResult, prizeMoney, user.lottoCount);

        // 9. 당첨 결과 출력
        Output.printResult(lottoResult, earningRate);


    }

}
