package lotto.domain;

import static lotto.domain.InputChecker.readLottoPrice;
import static lotto.domain.Lottos.generateLottos;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoGame {
    LottoResult lottoResult;
    InputChecker inputChecker;

    public LottoGame() {
        lottoResult = new LottoResult();
        inputChecker = new InputChecker();
    }

    public void start() {
        long userLottoPrice = inputChecker.readLottoPrice();
        long lottoCount = lottoResult.lottoNumbersPurchased(userLottoPrice);
        System.out.println(lottoCount + "개를 구매했습니다.");

        // 로또(들) 생성
        Lottos purchasedLottos = generateLottos(lottoCount);

        purchasedLottos.printLottos(); // #

        List<Integer> winningNumbers = inputChecker.readWinningNumbers();
        System.out.println("winningNumbers = " + winningNumbers); // #

        Integer bonusNumber = inputChecker.readBonusNumber();

        System.out.println("bonusNumber = " + bonusNumber); // #

        // 통계
        lottoResult.printRewardStatistics(purchasedLottos,winningNumbers,bonusNumber);

        // 수익률


    }

}
