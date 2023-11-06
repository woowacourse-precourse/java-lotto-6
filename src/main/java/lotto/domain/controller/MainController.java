package lotto.domain.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.view.InputView;
import lotto.domain.service.LottoCalculator;
import lotto.domain.service.LottoGenerator;
public class MainController {
    public int calculateLottoCount() {
        InputView inputView = new InputView();
        int userPurchasePrice = inputView.inputLottoPrice();

        LottoCalculator lottoCalculator = new LottoCalculator();
        int lottoCount = lottoCalculator.calculateNumberOfLotto(userPurchasePrice);

        return lottoCount;
    }

    public List<Lotto> generateLottos(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }

        return lottos;
    }


}
