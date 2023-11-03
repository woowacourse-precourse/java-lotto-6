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
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void run() {

        Lottos lottos = issueLotto();
        printIssuedLottoInAscending(lottos);

        WinningLotto winningLotto = receiveWinningNumbers();
        BonusNumber bonusNumber = receiveBonusNumber();

        // TODO: 결과 비교
        // TODO: 당첨 내역 출력
        // TODO: 수익률 출력
    }

    private static Lottos issueLotto() {
        int lottoQuantity = LottoQuantity.of(InputView.inputBuyingPrice());
        List<Lotto> lottos = LottoFactory.createLottos(lottoQuantity);
        return new Lottos(lottos);
    }

    private static void printIssuedLottoInAscending(Lottos lottos) {
        List<IssuedLottoResponse> lottoResponses = IssuedLottoResponse.of(lottos.getLottos());
        OutputView.printIssuedLottoCountAndNumbers(lottoResponses);
    }

    private static WinningLotto receiveWinningNumbers() {
        return WinningLottoFactory.of(InputView.inputWinningNumbers());
    }

    private static BonusNumber receiveBonusNumber() {
        return new BonusNumber(InputView.inputBonusNumber());
    }
}