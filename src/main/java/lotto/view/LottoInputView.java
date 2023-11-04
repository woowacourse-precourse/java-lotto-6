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


    public List<String> getWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(","))
                .toList();
    }

    public Integer getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
