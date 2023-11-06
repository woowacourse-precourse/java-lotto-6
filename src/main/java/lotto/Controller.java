package lotto;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.player.Player;

/**
 * 당첨 번호를 입력해 주세요.
 * 1,2,3,4,5,6
 * <p>
 * 보너스 번호를 입력해 주세요.
 * 7
 * <p>
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */
class Controller {

    private final LottoMachine lottoMachine;

    public Controller(LottoFactory factory) {
        this.lottoMachine = LottoMachine.from(factory);
    }

    public void run() {
        Player player = createPlayer();
        OutputView.printIssuanceResult(player.showLotto());

        Lotto answerLotto = requestAnswerLotto();
    }

    private Player createPlayer() {
        return Player.from(requestPlayerMoney(), lottoMachine);
    }

    private Money requestPlayerMoney() {
        return Mapper.mapToMoney(InputView.readPlayerMoney());
    }

    private static Lotto requestAnswerLotto() {
        return Mapper.mapToLotto(InputView.readAnswerLotto());
    }
}
