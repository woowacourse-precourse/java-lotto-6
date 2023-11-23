package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.amount.AmountExceptionStatus;
import lotto.exception.exceptions.CustomNullPointAmountException;
import lotto.exception.exceptions.CustomNumberFormatAmountException;
import lotto.utils.Delimiter;
import lotto.view.output.OutputView;

public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }

    public int readAmount() {
        outputView.printReadAmountMessage();
        return parseNumber(readLine());
    }

    public List<Integer> readWinningLotto() {
        outputView.printReadWinningLottoMessage();
        return parseWinning(readLine());
    }

    private List<Integer> parseWinning(final String winning) {
        return Arrays.stream(Delimiter.splitWithComma(winning))
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(final String target) {
        try {
            return Integer.parseInt(isNull(target));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(AmountExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNull(final String target) {
        try {
            return target.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(AmountExceptionStatus.READ_IS_NULL);
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
