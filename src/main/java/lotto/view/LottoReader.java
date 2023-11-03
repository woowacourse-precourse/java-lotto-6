package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class LottoReader {

    public int inputMoney() {
        while (true) {
            try {
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 로또 구입 금액은 숫자여야 합니다. 다시 입력해 주세요.");
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

    public int inputBonusNumbers() {
        while (true) {
            try {
                String inputBonusNumber = Console.readLine();
                return Integer.parseInt(inputBonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다. 다시 입력해 주세요.");
            }
        }
    }
}
