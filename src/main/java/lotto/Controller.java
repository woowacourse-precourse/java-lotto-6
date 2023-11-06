package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoFactory;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.player.Player;

import java.util.function.Supplier;

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

    private void printLottoResult(Player player) {
        Lotto answerLotto = createAnswerLotto();
        LottoNumber bonus = createBonus();

        handlePrintRaffleResultError(player, answerLotto, bonus);
    }

    private void handlePrintRaffleResultError(Player player, Lotto answerLotto, LottoNumber bonus) {
        try {
            printLottoResult(player, answerLotto, bonus);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            printLottoResult(player);
        }
    }

    private void printLottoResult(Player player, Lotto answerLotto, LottoNumber bonus) {
        OutputView.printStatistics(player.showStatistics(answerLotto, bonus));
        OutputView.printEarningRate(player.showEarningRate(answerLotto, bonus));
    }

    private Player createPlayer() {
        return handleSupplierError(() -> Player.from(Mapper.mapToMoney(InputView.readPlayerMoney()), lottoMachine));
    }

    private Lotto createAnswerLotto() {
        return handleSupplierError(() -> Mapper.mapToLotto(InputView.readAnswerLotto()));
    }

    private LottoNumber createBonus() {
        return handleSupplierError(() -> Mapper.mapToLottoNumber(InputView.readBonus()));
    }

    private <T> T handleSupplierError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return handleSupplierError(supplier);
        }
    }
}
