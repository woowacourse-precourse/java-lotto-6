package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoInputView {

    public LottoInputView() {
    }

    public Long getLottoPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        // TODO : 예외 처리 [ERROR]

        return Long.parseLong(purchaseAmount);
    }

    public List<String> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        return Arrays.stream(userInput.split(","))
                .toList();
    }
}
