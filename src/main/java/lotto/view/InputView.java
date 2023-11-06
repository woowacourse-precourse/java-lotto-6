package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static String requestLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static List<Integer> requestWinningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String stringInput = Console.readLine();

        String[] stringWinningLottoNumbers = stringInput.split(",");

        return Arrays.stream(stringWinningLottoNumbers)
                .map(Integer::parseInt).toList();
    }
}
