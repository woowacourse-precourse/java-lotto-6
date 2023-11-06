package lotto;

import lotto.domain.common.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.player.Player;

class Controller {

    private final LottoMachine lottoMachine;

    public Controller(LottoFactory factory) {
        this.lottoMachine = LottoMachine.from(factory);
    }

    public void run() {
        Player player = createPlayer();
        OutputView.printIssuanceResult(player.showLotto());
        printLottoResult(player);
    }

    private Player createPlayer() {
        return Player.from(requestPlayerMoney(), lottoMachine);
    }

    private void printLottoResult(Player player) {
        Lotto answerLotto = requestAnswerLotto();
        LottoNumber bonus = requestBonus();

        OutputView.printStatistics(player.showStatistics(answerLotto, bonus));
        OutputView.printEarningRate(player.showEarningRate(answerLotto, bonus));
    }

    private Money requestPlayerMoney() {
        return Mapper.mapToMoney(InputView.readPlayerMoney());
    }

    private Lotto requestAnswerLotto() {
        return Mapper.mapToLotto(InputView.readAnswerLotto());
    }

    private LottoNumber requestBonus() {
        return Mapper.mapToLottoNumber(InputView.readBonus());
    }
}
