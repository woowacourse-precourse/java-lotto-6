package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.WinningLottoFactory;
import lotto.dto.IssuedLottoResponse;
import lotto.dto.WinningResultResponse;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {
        int lottoQuantity = getLottoQuantity();

        Lottos playerLottos = generateLottos(lottoQuantity);
        printSortedLottos(playerLottos);

        WinningLotto winningLotto = generateWinningLotto();
        getWinningResult(playerLottos, winningLotto);

        // TODO: 당첨 내역 출력
        // TODO: 수익률 출력
    }

    private static int getLottoQuantity( ) {
        return LottoQuantity.of(InputView.inputBuyingPrice());
    }

    private static Lottos generateLottos(int lottoQuantity) {
        List<Lotto> lottos = LottoFactory.createLottos(lottoQuantity);
        return new Lottos(lottos);
    }

    private static void printSortedLottos(Lottos lottos) {
        List<IssuedLottoResponse> lottoResponses = IssuedLottoResponse.of(lottos.getLottos());
        OutputView.printIssuedLottoCountAndNumbers(lottoResponses);
    }

    private static WinningLotto generateWinningLotto() {
        WinningLotto winningLotto = WinningLottoFactory.of(InputView.inputWinningNumbers());
        winningLotto.setBonusNumber(generateBonusNumber());
        return winningLotto;
    }

    private static BonusNumber generateBonusNumber() {
        return new BonusNumber(InputView.inputBonusNumber());
    }

    private static WinningResultResponse getWinningResult(Lottos playerLottos, WinningLotto winningLotto) {
        return playerLottos.generateWinningResult(winningLotto);
    }
}