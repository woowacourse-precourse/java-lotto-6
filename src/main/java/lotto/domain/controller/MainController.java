package lotto.domain.controller;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.model.Receipt;
import lotto.domain.model.Result;
import lotto.domain.service.LottoService;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;
import lotto.global.util.Converter;
import lotto.global.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public MainController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void startLotto() {
        // 구입금액 입력
        outputView.printPriceLine();
        String inputPrice = inputView.readInputData();
        // 구입금액 검증
        Integer price = Converter.convertToNumber(inputPrice);
        List<Lotto> lottos = new ArrayList<>();
        // 로또 발매
        int count = price / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> generatedNumbers = RandomNumberGenerator.generateRandomNumber();
            Lotto generatedLotto = new Lotto(generatedNumbers);
            lottos.add(generatedLotto);
        }
        outputView.printLottoLine(lottos);
        // 당첨 번호 입력
        outputView.printNumbersLine();
        String inputNumbers = inputView.readInputData();
        // 당첨 번호 검증
        List<Integer> numbers = Converter.covertToNumbers(inputNumbers);
        Lotto lotto = new Lotto(numbers);
        // 보너스 번호 입력
        outputView.printBonusNumberLine();
        String inputBonusNumber = inputView.readInputData();
        // 보너스 번호 검증
        Integer bonusNumber = Converter.convertToNumber(inputBonusNumber);
        Bonus bonus = new Bonus(bonusNumber);
        List<Result> results = new ArrayList<>();
        // 로또 비즈니스
        for (Lotto generatedLotto : lottos) {
            Result result = lottoService.checkLotto(generatedLotto, lotto, bonus);
            results.add(result);
        }
        Receipt receipt = lottoService.calculateLottoRate(price, results);
        // 결과
        outputView.printResultLine(receipt);
    }
}
