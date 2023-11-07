package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.Referee;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final Referee referee = new Referee();
    private static final LottoController lottoController = new LottoController(referee);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    private static void start() {
        //로또 구매 금액 입력
        final int money = lottoController.inputPurchaseMoney();

        //로또 생성
        final List<Lotto> newLottos = LottoManager.createLottos(money);
        OutputView.printLottoSize(newLottos);
        newLottos.forEach(System.out::println);

        //당첨 로또 생성
        createWinningLotto(newLottos);
    }

    private static void createWinningLotto(final List<Lotto> newLottos) {
        //당첨 번호 입력
        final List<Integer> winningNumbers = lottoController.inputWinningLottoNumbers();

        //보너스 번호 입력
        final int bonusNumber = lottoController.inputWinningLottoBonusNumber(winningNumbers);

        //당첨 로또 생성
        final WinningLotto newWinningLotto = new WinningLotto(winningNumbers, bonusNumber);
        result(newLottos, newWinningLotto);
    }

    private static void result(final List<Lotto> newLottos, final WinningLotto newWinningLotto) {
        //결과 출력
        LottoManager lottoManager = new LottoManager(newLottos, newWinningLotto);
        final List<Lotto> lottos = lottoManager.getLottos();
        final WinningLotto winningLotto = lottoManager.getWinningLotto();
        lottoController.getLottoResult(lottos, winningLotto);
    }
}
