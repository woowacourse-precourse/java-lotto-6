package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;

public class LottoReader {

    public Money inputMoney() {
        while (true) {
            try {
                return new Money(Integer.parseInt(Console.readLine()));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 구입 금액은 숫자여야 합니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = Console.readLine();
                String[] split = inputWinningNumbers.split(",");
                if (split.length != Lotto.LOTTO_NUMBER_SIZE) {
                    throw new IllegalArgumentException("[ERROR] 로또 숫자는 6개만 입력이 가능합니다. 다시 입력해 주세요.");
                }
                return Arrays.stream(split).map(Integer::parseInt).toList();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public int inputBonusNumbers(List<Integer> winningNumbers) {
        while (true) {
            try {

                int bonusNumber = Integer.parseInt(Console.readLine());
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다. 다시 입력해 주세요.");
                }
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
