package lotto.controller;

import lotto.model.LottoMatchCount;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.parser.BonusNumberParser;
import lotto.service.LottoService;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.FinalResult;
import lotto.parser.LottoParser;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import static lotto.service.LottoService.checkTotalMatchCount;

public class LottoController {
    public static void play() {
        String price = LottoInputView.requestInputPrice();
        Lottos randomLottos = makeRandomLottos(price);
        String winningNumbers = LottoInputView.requestInputWinningNumbers();
        Lotto winningLotto = makeWinningLotto(winningNumbers);
        BonusNumber bonus = makeBonusNumber(winningLotto);
        checkLottoResult(randomLottos, bonus, winningLotto, price);
    }
    private static Lottos makeRandomLottos(String price) {
        Lottos randomLottos = LottoService.create(price);
        LottoOutputView.printResponsePurchaseAmount(randomLottos.getLottoLength());
        LottoOutputView.printRandomLottos(randomLottos);
        return randomLottos;
    }
    private static BonusNumber makeBonusNumber(Lotto winningLotto) {
        String bonusNumber = LottoInputView.requestInputBonusNumber();
        return BonusNumberParser.parse(winningLotto, bonusNumber);
    }
    private static Lotto makeWinningLotto(String winningNumbers) {
        return LottoParser.parse(winningNumbers);
    }
    private static void checkLottoResult(Lottos randomLottos, BonusNumber bonus, Lotto winningLotto, String price) {
        LottoMatchCount lottoMatchCount = checkTotalMatchCount(randomLottos, bonus,winningLotto);
        LottoResult lottoResult = createLottoResult(lottoMatchCount);
        LottoOutputView.printResultMessages();
        FinalResult finalResult = createFinalResult(lottoResult);
        LottoOutputView.printResultMessage(finalResult,Integer.parseInt(price));
    }
    private static LottoResult createLottoResult(LottoMatchCount lottoMatchCount) {
        return new LottoResult(lottoMatchCount);
    }
    private static FinalResult createFinalResult(LottoResult lottoResult) {
        return new FinalResult(lottoResult);
    }
}
