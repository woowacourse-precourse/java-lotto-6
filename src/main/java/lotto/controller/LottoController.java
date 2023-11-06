package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
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
        LottoResult lottoResult = new LottoResult(randomLottos, winningLotto, Integer.parseInt(bonusNumber));

        LottoView.responseResultMessages();
        FinalResult finalResult = new FinalResult(lottoResult);
        finalResult.printResult();
        finalResult.printProfitRate(Integer.parseInt(price));

    }
}
