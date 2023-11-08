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
import lotto.global.util.Validator;

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
        int price = readPriceAndValidatePriceAndGetPrice();
        List<Lotto> lottos = generatedLottos(price);
        Lotto lotto = readNumbersAndValidateNumbersAndGetLotto();
        Bonus bonus = readBonusNumberAndValidateBonusNumberAndGetBonus();
        Receipt receipt = checkLottoAndGetReceipt(price, lottos, lotto, bonus);
        outputView.printResultLine(receipt);
    }

    private int readPriceAndValidatePriceAndGetPrice() {
        String inputPrice = readInputPrice();
        try {
            Validator.validatePrice(inputPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readInputPrice();
        }
        return Converter.convertToNumber(inputPrice);
    }

    private List<Lotto> generatedLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int count = price / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> generatedNumbers = RandomNumberGenerator.generateRandomNumber();
            Lotto generatedLotto = new Lotto(generatedNumbers);
            lottos.add(generatedLotto);
        }
        outputView.printLottoLine(lottos);
        return lottos;
    }

    private Lotto readNumbersAndValidateNumbersAndGetLotto() {
        String inputNumbers = readInputNumbers();
        try {
            Validator.validateNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readInputNumbers();
        }
        List<Integer> numbers = Converter.covertToNumbers(inputNumbers);
        return new Lotto(numbers);
    }

    private Bonus readBonusNumberAndValidateBonusNumberAndGetBonus() {
        String inputBonusNumber = readInputBonusNumber();
        try {
            Validator.validateBonusNumber(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readInputBonusNumber();
        }
        Integer bonusNumber = Converter.convertToNumber(inputBonusNumber);
        return new Bonus(bonusNumber);
    }

    private Receipt checkLottoAndGetReceipt(int price, List<Lotto> lottos, Lotto lotto, Bonus bonus) {
        List<Result> results = new ArrayList<>();
        for (Lotto generatedLotto : lottos) {
            Result result = lottoService.checkLotto(generatedLotto, lotto, bonus);
            results.add(result);
        }
        return lottoService.calculateLottoRate(price, results);
    }

    private String readInputPrice() {
        outputView.printPriceLine();
        return inputView.readInputData();
    }

    private String readInputNumbers() {
        outputView.printNumbersLine();
        return inputView.readInputData();
    }

    private String readInputBonusNumber() {
        outputView.printBonusNumberLine();
        return inputView.readInputData();
    }
}
