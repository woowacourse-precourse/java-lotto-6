package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.exception.ParseException;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    @Override
    public int enterPurchaseAmount() {
        return parseInt(readLine());
    }

    @Override
    public List<Integer> enterWinningLottoNumbers() {
        return Arrays.stream(readLine().split(","))
                .map(String::trim)
                .mapToInt(this::parseInt)
                .boxed()
                .toList();
    }

    @Override
    public int enterBonusLottoNumber() {
        return parseInt(readLine());
    }

    private Integer parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ParseException();
        }
    }
}
