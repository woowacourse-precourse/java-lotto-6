package lotto.formatter;

import lotto.constants.ViewElement;
import lotto.constants.message.ProgressMessage;
import lotto.domain.lotto.Number;
import lotto.domain.lotto.Numbers;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerLottosFormatter {
    private final List<Numbers> resultLottos;

    public PlayerLottosFormatter(List<Numbers> resultLottos) {
        this.resultLottos = resultLottos;
    }

    public String toPlayerLottosResultMessage() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ProgressMessage.PURCHASE_LOTTOS_MESSAGE, resultLottos.size()))
                .append(ViewElement.NEXT_LINE);
        resultLottos.forEach(numbers -> sb.append(getFormattedValues(numbers)).append(ViewElement.NEXT_LINE));

        return sb.toString();
    }

    private String getFormattedValues(Numbers numbers) {
        return numbers.getValues().stream()
                .map(Number::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(ViewElement.DELIMITER_COMMA, ViewElement.LEFT_BRACKET, ViewElement.RIGHT_BRACKET));
    }
}
