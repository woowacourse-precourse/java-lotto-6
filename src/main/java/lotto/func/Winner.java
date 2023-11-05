package lotto.func;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class Winner {
    public void winNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> inputNumbers = Arrays.asList(input.split(","));
        List<Integer> winningNumbers = new ArrayList<>();

        for (String numberStr : inputNumbers) {
            int winningNum = Integer.parseInt(numberStr.trim());
            winningNumbers.add(winningNum);
        }
        Lotto lotto = new Lotto(winningNumbers);
        bonusNumber();
    }

    private int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        int bonusNum = Integer.parseInt(bonus);

        return bonusNum;
    }
}
