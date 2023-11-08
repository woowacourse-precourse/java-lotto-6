package lotto;

import controller.InputController;
import controller.OutputController;
import domain.Lotto;
import domain.WinningLotto;
import service.LottoService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount;
        List<Lotto> lottos;
        WinningLotto winningLotto;

        purchaseAmount = InputController.purchaseAmount();
        lottos = buyLottos(purchaseAmount);
        winningLotto = setWinningLotto();
        OutputController.winningStatistics(winningLotto, lottos, purchaseAmount);
    }

    public static List<Lotto> buyLottos(Integer purchaseAmount) {
        List<Lotto> lottos;

        lottos = LottoService.purchaseLotto(purchaseAmount);
        System.out.println();
        OutputController.purchaseLottos(lottos);
        System.out.println();

        return lottos;
    }

    public static WinningLotto setWinningLotto() {
        WinningLotto winningLotto;
        List<Integer> winningNumbers;
        int bonusNumber;

        winningNumbers = InputController.winningNumbers();
        System.out.println();
        bonusNumber = InputController.bonusNumber(winningNumbers);
        System.out.println();
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        return winningLotto;
    }
}
