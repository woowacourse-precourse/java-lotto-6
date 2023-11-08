package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class WinningLotto {

    static Lotto winningLotto;
    static int bonusNumber;

    static public void gettingWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        try {
            winningLotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingWinningNumbers();
        }
    }

    static public void gettingBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        bonusNumber = Integer.parseInt(input);
        validateBonusNumber();
    }

    static public void validateBonusNumber() {
        try {
            if (bonusNumber < 1 | bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않은 번호를 입력해 주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            gettingBonusNumber();
        }
    }
}
