package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.parser.BonusNumberParser;
import lotto.service.LottoService;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.parser.FinalResult;
import lotto.parser.LottoParser;
import lotto.view.LottoView;

public class LottoController {
    public static void play() {
        String price = LottoView.requestInputPrice();
        Lottos randomLottos = LottoService.generate(price);
        LottoView.printResponsePurchaseAmount(randomLottos.getLottoLength());
        LottoView.printRandomLottos(randomLottos);
        String winningNumbers = LottoView.requestInputWinningNumbers();
        Lotto winningLotto = LottoParser.parse(winningNumbers);
        String bonusNumber = LottoView.requestInputBonusNumber();
        BonusNumber bonus = BonusNumberParser.parse(winningLotto, bonusNumber);
        LottoResult lottoResult = createLottoResult(randomLottos, winningLotto, bonus);
        LottoView.printResultMessages();
        FinalResult finalResult = createFinalResult(lottoResult);
        LottoView.printResultMessage(finalResult,Integer.parseInt(price));
    }
    private static LottoResult createLottoResult(Lottos randomLottos, Lotto winningLotto, BonusNumber bonus) {
        return new LottoResult(randomLottos, winningLotto, bonus);
    }
    private static FinalResult createFinalResult(LottoResult lottoResult) {
        return new FinalResult(lottoResult);
    }
}
