package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoWinningNumber;

import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS = "보너스 번호를 입력해 주세요.";

    public static String inputPlayerLottoPrice() {
        System.out.println(INPUT_LOTTO_PRICE);
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinNumber() {
        System.out.println(INPUT_LOTTO_WINNING);
        return LottoWinningNumber.getWinningNumbers(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS);
        return Integer.parseInt(Console.readLine());
    }
}
