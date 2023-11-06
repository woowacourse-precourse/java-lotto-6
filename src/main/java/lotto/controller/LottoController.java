package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.UserAmountValidator;
import lotto.controller.validator.WinningNumbersValidator;
import lotto.domain.*;
import lotto.io.Input;
import lotto.io.Output;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final Input input;
    private final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Money money = new Money(generateMoney());
        LottoQuantity lottoQuantity = new LottoQuantity(money.getQuantity());
        output.printPurchaseQuantity(lottoQuantity.getQuantity());

        List<Lotto> myLottos = buyLottos(lottoQuantity);
        WinningNumbers winningNumbers = new WinningNumbers(generateWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(generateBonusNumber(winningNumbers));

        WinningLottoCounts winningLottoCounts = new WinningLottoCounts(myLottos, winningNumbers, bonusNumber);
        Profit profit = new Profit(winningLottoCounts, money);
        output.printResult(winningLottoCounts, profit.calculate());
    }

    private int generateMoney() {
        int money;
        try {
            output.printInputPurchaseAmountMessage();
            money = getUserAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = generateMoney();
        }
        return money;
    }

    private int getUserAmount() {
        UserAmountValidator userAmountValidator = new UserAmountValidator();
        String userInput = input.getUserAmount();
        userAmountValidator.validateUserAmout(userInput);
        return Integer.parseInt(userInput);
    }

    private List<Lotto> buyLottos(LottoQuantity lottoQuantity) {
        Lottos lottos = new Lottos(lottoQuantity);
        List<Lotto> myLottos = lottos.getMyLottos();
        output.printMyLottos(myLottos);
        return myLottos;
    }

    private List<Integer> generateWinningNumbers() {
        List<Integer> winningNumbers;
        try {
            output.printInputWinningNumbersMessage();
            winningNumbers = getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers = generateWinningNumbers();
        }
        return winningNumbers;
    }

    private List<Integer> getWinningNumbers() {
        List<String> userInput = input.getWinningNumbers();
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        winningNumbersValidator.validateWinningNumbers(userInput);
        return userInput.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private int generateBonusNumber(WinningNumbers winningNumbers) {
        int bonusNumber;
        System.out.println();
        try {
            output.printInputBonusNumberMessage();
            bonusNumber = getBonusNumber(winningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = generateBonusNumber(winningNumbers);
        }
        Console.close();
        return bonusNumber;
    }

    private int getBonusNumber(WinningNumbers winningNumbers) {
        String userInput = input.getBonusNumber();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        bonusNumberValidator.validateBonusNumber(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        winningNumbers.validateDuplication(bonusNumber);
        return bonusNumber;
    }
}