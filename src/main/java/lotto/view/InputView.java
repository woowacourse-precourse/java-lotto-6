package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private static final String INPUT_Purchase_Amount = "구입금액을 입력해 주세요.";

    private StringTokenizer st;

    public int inputPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        return stringToListInteger(Console.readLine());
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> stringToListInteger(String input) {
        st = new StringTokenizer(input, ",");
        List<Integer> winningNumbers = new ArrayList<>();
        while(st.hasMoreTokens()) {
            winningNumbers.add(Integer.valueOf(st.nextToken()));
        }
        return winningNumbers;
    }
}
