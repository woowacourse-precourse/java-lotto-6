package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.parser.FinalResult;
import lotto.parser.LottoParser;
import lotto.view.LottoView;

public class LottoController {
    public static void play() {
        String price = LottoView.requestInputPrice();
        Lottos randomLottos = LottoGenerator.generate(price);
        LottoView.printResponsePurchaseAmount(randomLottos.getLottoLength());
        LottoView.printRandomLottos(randomLottos);
        String winningNumbers = LottoView.requestInputWinningNumbers();
        Lotto winningLotto = LottoParser.parse(winningNumbers);
        String bonusNumber = LottoView.requestInputBonusNumber();
        LottoResult lottoResult = createLottoResult(randomLottos, winningLotto, bonusNumber);
        LottoView.printResultMessages();
        FinalResult finalResult = createFinalResult(lottoResult);
        LottoView.printResultMessage(finalResult,Integer.parseInt(price));
    }
    private static LottoResult createLottoResult(Lottos randomLottos, Lotto winningLotto, String bonusNumber) {
        return new LottoResult(randomLottos, winningLotto, bonusNumber);
    }
    private static FinalResult createFinalResult(LottoResult lottoResult) {
        return new FinalResult(lottoResult);
    }
}
