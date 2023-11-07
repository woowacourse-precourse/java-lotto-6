package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.service.LottoService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        List<Lotto> lottos = lottoService.purchaseLotto();
        WinningLotto winningLotto = lottoService.createWinningLotto();
        WinningResult lottoResult = lottoService.getLottoResult(lottos, winningLotto);
        lottoService.printWinningResult(lottoResult);
    }
}
