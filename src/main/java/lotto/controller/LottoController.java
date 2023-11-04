package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoGeneratorServiceImpl;
import lotto.service.WinningLottoFactory;
import lotto.service.WinningLottoFactoryImpl;
import lotto.utils.NumberParser;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    WinningLottoFactory winningLottoFactory = new WinningLottoFactoryImpl();
    LottoGeneratorService lottoGeneratorService = new LottoGeneratorServiceImpl();
    public void start() {
        String inputPrice = inputView.inputPrice();
        int price = NumberParser.toInteger(inputPrice);
        List<Lotto> lottos = lottoGeneratorService.myLottos(price);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
        String winningNumbers = inputView.inputWinningNumbers();
        Lotto lotto = winningLottoFactory.winningLotto(winningNumbers);
        System.out.println(lotto.getNumbers());
        String inputBonusNumber = inputView.inputBonusNumber();
        BonusNumber bonusNumber = winningLottoFactory.bonusNumber(inputBonusNumber);
        System.out.println(bonusNumber.getBonusNumber());
    }
}
