package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.io.Input;
import lotto.io.Output;

import java.util.Collections;
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
        Money money = new Money(getUserAmount());
        LottoQuantity lottoQuantity = new LottoQuantity(money.getQuantity());
        output.printPurchaseQuantity(lottoQuantity.getQuantity());

        List<Lotto> myLottos = buyLottos(lottoQuantity);
        WinningNumbers winningNumbers = new WinningNumbers(generateWinningNumbers());
        BonusNumber bonusNumber = new BonusNumber(generateBonusNumber(winningNumbers));

        WinningLottoCounts winningLottoCounts = new WinningLottoCounts(myLottos, winningNumbers, bonusNumber);
        Profit profit = new Profit(winningLottoCounts, money);
        output.printResult(winningLottoCounts, profit.calculate());
    }

    private int getUserAmount() {
        int money;
        UserAmountValidator userAmountValidator = new UserAmountValidator();
        try {
            output.printInputPurchaseAmountMessage();
            String userInput = input.getUserAmount();
            userAmountValidator.validateUserAmout(userInput);
            money = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = getUserAmount();
        }
        return money;
    }

    private List<Lotto> buyLottos(LottoQuantity lottoQuantity) {
        Lottos lottos = new Lottos(lottoQuantity);
        List<Lotto> myLottos = lottos.getMyLottos();
        output.printMyLottos(myLottos);
        return myLottos;
    }

    private List<Integer> generateWinningNumbers() {
        List<Integer> winningNumbers;
        WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
        try {
            output.printInputWinningNumbersMessage();
            List<String> userInput = input.getWinningNumbers();
            winningNumbersValidator.validateWinningNumbers(userInput);
            winningNumbers = userInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers = generateWinningNumbers();
        }
        return winningNumbers;
    }

    private int generateBonusNumber(WinningNumbers winningNumbers) {
        int bonusNumber;
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        System.out.println();
        try {
            output.printInputBonusNumberMessage();
            String userInput = input.getBonusNumber();
            bonusNumberValidator.validateBonusNumber(userInput);
            bonusNumber = Integer.parseInt(userInput);
            winningNumbers.validateDuplication(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = generateBonusNumber(winningNumbers);
        }
        Console.close();
        return bonusNumber;
    }
}