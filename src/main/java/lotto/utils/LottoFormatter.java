package lotto.utils;

import lotto.domain.Lotto;

import java.util.List;

public class LottoFormatter implements Formatter<List<Lotto>> {

    @Override
    public String format(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            String convertNumbers = convert(lotto.getSortedNumbers());

            stringBuilder.append(String.format(convertNumbers + "%n"));
        }

        return stringBuilder.toString();
    }

    private String convert(List<Integer> numbers) {
        return String.valueOf(numbers);
    }
}
