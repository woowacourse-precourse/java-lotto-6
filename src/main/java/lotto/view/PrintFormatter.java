package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.view.constant.CharacterSymbol;

public class PrintFormatter {

    private static final String LOTTO_PURCHASE_QUANTITY_FORMAT = "%d개를 구매했습니다.";

    public String toLottoNumberPrintFormat(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .map(numbers -> numbers.stream()
                        .sorted(Integer::compareTo)
                        .toList())
                .map(numbers -> Arrays.toString(numbers.toArray()))
                .collect(Collectors.joining(CharacterSymbol.BLANK.getLiteral() + System.lineSeparator()));
    }

    public String toLottoPurchaseQuantityFormat(int quantity) {
        return LOTTO_PURCHASE_QUANTITY_FORMAT.formatted(quantity);
    }

}
