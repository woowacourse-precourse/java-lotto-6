package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int getMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public List<Integer> getMatchNumbers() {
        List<Integer> matchNumbers = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt).toList();
        if (matchNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호 리스트는 6개의 숫자입니다.");
        }
        matchNumbers.forEach(matchNumber -> {
            if (matchNumber < 1 | matchNumber > 45) {
                throw new IllegalArgumentException("각 당첨 번호는 1이상 45 이하의 숫자입니다.");
            }
        });
        return matchNumbers;
    }

    public int getBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 | bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1이상 45 이하의 숫자입니다.");
        }
        return bonusNumber;
    }
}
