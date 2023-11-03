package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoInputView {

    public LottoInputView() {
    }

    public Long getLottoPurchaseAmountInput() {
        Long purchaseAmount = null;
        while (purchaseAmount == null) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String input = Console.readLine();
                purchaseAmount = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해주세요.");
            }
        }
        return purchaseAmount;
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
