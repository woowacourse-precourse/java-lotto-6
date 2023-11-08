package lotto;

import lotto.controller.LottoController;
import lotto.handler.UserHandler;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();

        // 사용자로부터 구매금액을 입력받음
        int amount = UserHandler.getAmountFromUser();

        // 로또 개수 계산
        int lottoCount = UserHandler.getLottoCountFromUser(amount);

        // 로또 구매
        lottoController.buyLottos(lottoCount);

        // 사용자로부터 당첨 번호를 받음
        List<String> winningNumbers = UserHandler.getWinningNumberFromUser();

        // 당첨 번호를 바탕으로 당첨 로또를 생성.
        Lotto winningLotto = lottoController.createWinningLotto(winningNumbers);

        // 사용자로부터 보너스 번호를 받음
        int bonusNumber = UserHandler.getAndValidateBonusNumber(winningNumbers);

    }
}

