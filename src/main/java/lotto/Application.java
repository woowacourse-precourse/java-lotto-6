package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Computer;
import lotto.domain.User;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> lottos;

        User user = new User();
        user.purchaseLotto();

        // 로또 개수 만큼 번호 계산
        lottos = Application.createLottos(user.lottoCount);

        // 4. 로또 번호 출력
        Application.printLottos(lottos);

        // 5. 당첨 번호 입력
        Lotto winningLotto = createWinningLotto();

        // 6. 보너스 번호 입력
        Integer bonusNumber = createBonusNumber(winningLotto);

        // 7. 당첨 내역 계산 로직
        List<Integer> lottoResult = checkWinning(lottos, winningLotto, bonusNumber);

        // 당첨금
        List<Integer> prizeMoney = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000));

        // 8. 수익률 계산 로직
        Double earningRate = calculateEarningRate(lottoResult, prizeMoney, user.lottoCount);

        // 9. 당첨 결과 출력
        printResult(lottoResult, earningRate);


    }

}
