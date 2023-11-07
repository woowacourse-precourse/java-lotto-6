package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static List<Long> matchWinningNumber = new ArrayList<>();
    private static List<Long> matchBonusNumber = new ArrayList<>();

    private List<Integer> winningNumbers;
    private int bonusNumber;


    public void inputWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBER);
        winningNumbers = toWinningNumberList(readLine());
        System.out.println();
        System.out.println(BONUS_NUMBER);
        bonusNumber = Integer.parseInt(readLine());
        System.out.println();
    }


    public List<Integer> toWinningNumberList(String numbers) {
        String[] num = numbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : num) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public void compareToLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            matchWinningNumber.add(winningNumbers.stream().filter(w -> lotto.getNumbers().contains(w))
                    .count());
            matchBonusNumber.add(lotto.getNumbers().stream().filter(l -> l.equals(bonusNumber)).count());
        }
    }

    public static List<Long> getMatchWinningNumber() {
        return matchWinningNumber;
    }

    public static List<Long> getMatchBonusNumber() {
        return matchBonusNumber;
    }
}
