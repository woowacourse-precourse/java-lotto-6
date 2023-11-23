package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.amount.AmountExceptionStatus;
import lotto.exception.exceptions.CustomNullPointAmountException;
import lotto.exception.exceptions.CustomNumberFormatAmountException;
import lotto.exception.winning.BonusExceptionStatus;
import lotto.exception.winning.WinningExceptionStatus;
import lotto.utils.Delimiter;
import lotto.view.output.OutputView;

public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }

    public int readAmount() {
        outputView.printReadAmountMessage();
        return parseAmount(readLine());
    }

    public List<Integer> readWinningLotto() {
        outputView.printReadWinningLottoMessage();
        return parseWinning(readLine());
    }

    public int readBonus() {
        outputView.printReadWinningLottoMessage();
        return parseBonus(readLine());
    }

    private int parseBonus(final String bonus) {
        try {
            return Integer.parseInt(isNullBonus(bonus));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(BonusExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullBonus(final String winning) {
        try {
            return winning.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(BonusExceptionStatus.READ_IS_NULL);
        }
    }

    private List<Integer> parseWinning(final String winning) {
        return Arrays.stream(Delimiter.splitWithComma(winning))
                .map(this::parseNumber)
                .toList();
    }

    private int parseNumber(final String winning) {
        try {
            return Integer.parseInt(isNullWinning(winning));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(WinningExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullWinning(final String winning) {
        try {
            return winning.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(WinningExceptionStatus.READ_IS_NULL);
        }
    }

    private int parseAmount(final String amount) {
        try {
            return Integer.parseInt(isNullAmount(amount));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(AmountExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullAmount(final String amount) {
        try {
            return amount.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(AmountExceptionStatus.READ_IS_NULL);
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
