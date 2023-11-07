package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    public int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요 (1부터 45까지의 숫자, 쉼표로 구분).");
        String input = Console.readLine();

        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요 (1부터 45까지의 숫자).");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
