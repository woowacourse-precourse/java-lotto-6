package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validator;
import lotto.view.LottoView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final LottoView lottoView;

    public LottoController() {
        this.lottoView = new LottoView();
    }

    public int inputPurchaseMoney() {
        lottoView.printPurchasePrompt();
        String purchaseMoney = "";
        while (true) {
            try {
                purchaseMoney = Console.readLine();
                Validator.validatePurchaseMoney(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(purchaseMoney);
    }

    public List<Integer> inputWinningNumbers() {
        lottoView.printWinningPrompt();
        String winningNumbers = "";
        while (true) {
            try {
                winningNumbers = Console.readLine();
                Validator.validateWinningNumber(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return List.of(winningNumbers.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
