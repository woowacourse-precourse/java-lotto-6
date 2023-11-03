package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputVIew {
    private static final String COMMA = ",";

    public int promptLottoPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public int[] promptLottoWinningNumbers() {
        return Arrays.stream(Console.readLine().split(COMMA))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int promptLottoBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

}
