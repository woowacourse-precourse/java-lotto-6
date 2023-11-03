package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public String inputBuyingPrice() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return readLine().trim();
    }

    public List<String> inputLottoNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Arrays.stream(readLine().split(","))
                .map(String::trim)
                .toList();
    }

    private String readLine() {
        return Console.readLine();
    }
}
