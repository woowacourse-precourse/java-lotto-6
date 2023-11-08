package lotto.converter;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class MessageConverter {
    private static final String START_TAG = "[";
    private static final String SEPARATOR = ", ";
    private static final String END_TAG = "]";
    private static final String NEXT_LINE = "\n";
    public static String writePurchasedLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.writePurchasedLotto()).append(NEXT_LINE));
        return sb.toString();
    }

    public static String writePurchasedLotto(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(START_TAG);
        List<String> nums_str = numbers.stream().map(String::valueOf).toList();
        sb.append(String.join(SEPARATOR, nums_str));
        sb.append(END_TAG);
        return sb.toString();
    }
}
