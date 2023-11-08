package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine().trim());
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValue = Console.readLine().trim();
        String[] splitNumbers = inputValue.split(",");
        for (String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine().trim());
    }

}
