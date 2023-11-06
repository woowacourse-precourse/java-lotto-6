package lotto.dto;

import java.util.List;
import lotto.view.ViewConstant;

public record LottoTicket(List<Integer> numbers) {
    @Override
    public String toString() {
        List<String> strings = this.numbers.stream()
                .map(String::valueOf)
                .toList();
        return String.join(ViewConstant.TICKET_NUMBER_DELIMITER.value(), strings);
    }
}
