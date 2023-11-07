package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Jackpot {
    private Lotto winningNumbers;
    private int bonusNumber;

    public Jackpot() {
        this.winningNumbers = askForWinningNumbers();
        askForBonusNumber();
    }

    public Lotto askForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbers = readLine().split(",");
        List<Integer> arr = new ArrayList<>();
        for (String number : numbers) {
            arr.add(Integer.parseInt(number.trim()));
        }

        return new Lotto(arr);
    }

    public void askForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(readLine().trim());
    }
}
