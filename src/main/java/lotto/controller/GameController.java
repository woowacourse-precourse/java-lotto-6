package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        inputLottoDatas();
        finishGame();
    }

    private void inputLottoDatas() {
        inputPurchaseAmount();
        publishLotto();
        List<Integer> winningNumbers = inputWinningNumbers();
        inputBonusNumber(winningNumbers);
    }

    private void inputPurchaseAmount() {
        OutputView.println("구입금액을 입력해 주세요.");
        gameService.setPurchaseAmount(InputView.readPurchaseAmount());
        OutputView.println("");
    }

    private void publishLotto() {
        List<Lotto> lottos = createLottos();
        printPublishedLottoNumber(lottos);
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = gameService.publishLottoNumbers();
        OutputView.println(lottos.size() + "개를 구매했습니다.");

        return lottos;
    }

    private void printPublishedLottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            lotto.getNumbers().forEach(number -> sb.append(number).append(", "));
            sb.delete(sb.length()-2, sb.length());
            sb.append("]");
            OutputView.println(sb.toString());
        }
        OutputView.println("");
    }

    private List<Integer> inputWinningNumbers() {
        OutputView.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = gameService.createWinningLotto(InputView.readWinningNumbers());
        OutputView.println("");

        return winningLotto.getNumbers();
    }

    private void inputBonusNumber(List<Integer> winningNumbers) {
        OutputView.println("보너스 번호를 입력해 주세요.");
        gameService.setBonusNumber(InputView.readBonusNumber(winningNumbers));
        OutputView.println("");
    }

    private void finishGame() {
        OutputView.println("당첨 통계\n---");
        WinningResult winningResult = gameService.createWinningResult();

        System.out.println(
                winningResult.getThreeMatches() + " "
                        + winningResult.getFourMatches() + " "
                        + winningResult.getFiveMatches() + " "
                        + winningResult.getFiveAndBonusMatches() + " "
                        + winningResult.getSixMatches() + " "
                        + winningResult.getTotalReturn()
        );
    }
}
