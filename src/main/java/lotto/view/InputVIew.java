package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputVIew {
    private static final String COMMA = ",";

    public int promptLottoPurchaseAmount() {
        int number = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                number = Integer.parseInt(Console.readLine());
                isValidInput = true; // 유효한 입력을 받았을 때 반복문을 종료
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해주십시오");
            }
        }
        return number;
    }

    public List<Integer> promptLottoWinningNumbers() {
        return Arrays.stream(Console.readLine().split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int promptLottoBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
