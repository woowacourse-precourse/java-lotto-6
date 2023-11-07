package lotto.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = readLine();
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String input = readLine();

        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().toList();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String input = readLine();
        return Integer.parseInt(input);
    }


}
