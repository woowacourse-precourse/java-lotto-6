package lotto.view.service;

import lotto.validator.InputValidator;
import lotto.view.message.InputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ViewInputServiceImpl implements ViewInputService {

    @Override
    public void printMessagePurchaseAmount() {
        System.out.println(InputMessage.MESSAGE_PURCHASE_AMOUNT);
    }

    @Override
    public int inputPurchaseAmount() {
        try {
            return Integer.parseInt(InputValidator.validInputPurchaseAmount(readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    @Override
    public void printMessageWinningNumbers() {
        System.out.println(InputMessage.MESSAGE_WINNING_NUMBERS);
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        try {
            return Arrays.stream(InputValidator.validInputWinningNumbers(readLine())
                            .split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    @Override
    public void printMessageBonusNumber() {
        System.out.println("\n" + InputMessage.MESSAGE_BONUS_NUMBER);
    }

    @Override
    public int inputBonusNumber(List<Integer> winningNumbers) {
        try {
            return Integer.parseInt(InputValidator.validInputBonus(winningNumbers, readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
