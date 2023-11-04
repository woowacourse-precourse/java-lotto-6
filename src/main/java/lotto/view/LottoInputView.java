package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.ErrorMessage;
import lotto.global.LottoInputMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.global.ErrorMessage.*;
import static lotto.global.LottoInputMessage.*;

public class LottoInputView {

    public LottoInputView() {
    }

    public Long getLottoPurchaseAmountInput() {
        while (true) {
            System.out.println(LOTTO_PURCHASE_AMOUNT.getMessage());
            try {
                return Long.parseLong(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println(INPUT_NUMBER_IS_INVALID.getMessage());
            }
        }
    }


    public List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println();
            System.out.println(LOTTO_WINNING_NUMBER.getMessage());

            try {
                String userInput = Console.readLine();
                return Arrays.stream(userInput.split(","))
                        .map(this::convertToInt)
                        .toList();
            } catch (NumberFormatException e) {
                System.out.println(INPUT_NUMBER_IS_NOT_DIGIT.getMessage());
            }
        }

    }

    private int convertToInt(final String value) {
        return Integer.parseInt(value.trim());
    }

    public Integer getBonusNumber() {
        while (true) {
            System.out.println();
            System.out.println(LOTTO_BONUS_NUMBER.getMessage());

            try {
                String userInput = Console.readLine();
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_NUMBER_IS_NOT_DIGIT.getMessage());
            }
        }
    }
}
