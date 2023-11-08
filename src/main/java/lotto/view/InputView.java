package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println();
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }
}
