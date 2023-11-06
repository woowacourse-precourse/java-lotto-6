package lotto.formatter;

import lotto.constants.ProgressMessage;
import lotto.domain.Number;
import lotto.domain.Numbers;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerLottosFormatter {
    private static final String NEXT_LINE = "\n";
    private static final String DELIMITER_COMMA = ", ";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private final List<Numbers> resultLottos;

    public PlayerLottosFormatter(List<Numbers> resultLottos) {
        this.resultLottos = resultLottos;
    }

    public String toResultLottoMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ProgressMessage.PURCHASE_LOTTOS_MESSAGE, resultLottos.size()))
                .append(NEXT_LINE);
        resultLottos.forEach(numbers -> sb.append(getFormattedValues(numbers)).append(NEXT_LINE));

        return sb.toString();
    }

    private String getFormattedValues(Numbers numbers) {
        return numbers.getValues().stream()
                .map(Number::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER_COMMA, LEFT_BRACKET, RIGHT_BRACKET));
    }
}
