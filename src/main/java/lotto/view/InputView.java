package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int requestLottoPurchaseAmount() {
        while(true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String stringInput = Console.readLine();
                return Integer.parseInt(stringInput);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 구입금액을 다시 입력해주세요.");
            }
        }
    }

    public static List<Integer> requestWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String stringInput = Console.readLine();

                String[] stringWinningLottoNumbers = stringInput.split(",");

                return Arrays.stream(stringWinningLottoNumbers)
                        .map(Integer::parseInt)
                        .toList();
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 당첨 번호를 다시 입력해주세요.");
            }
        }
    }

    public static int requestBonusLottoNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String stringInput = Console.readLine();
                return Integer.parseInt(stringInput);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 올바른 입력이 아닙니다. 구입금액을 다시 입력해주세요.");
            }
        }
    }
}
