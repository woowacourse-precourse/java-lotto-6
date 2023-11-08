package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Ask {
    public List<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;

    public List<Integer> winningNumber() {
        winningNumbers.clear();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winning = Console.readLine();
        String[] number = winning.split(",");

        for (int i = 0; i < number.length; i++) {
            int num = Integer.parseInt(number[i]);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    public void winningException() {
        try {
            Lotto lotto = new Lotto(winningNumber());
        } catch (IllegalArgumentException e) {
            winningException();
        }
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
