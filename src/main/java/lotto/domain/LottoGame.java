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
        start();
    }

    private void start() {
        long userLottoPrice = inputChecker.readLottoPrice();
        long lottoCount = lottoResult.lottoNumbersPurchased(userLottoPrice);
        System.out.println(lottoCount + "개를 구매했습니다.");

        Lottos purchasedLottos = generateLottos(lottoCount);

        List<Integer> winningNumbers = inputChecker.readWinningNumbers();
        int bonusNumber = inputChecker.readBonusNumber();


    }

}
