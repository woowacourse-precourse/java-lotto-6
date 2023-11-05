package lotto.view;

import lotto.domain.Lotto;

import java.util.stream.Collectors;

public class OutputView {
    public static void outputBuyLottoCount(int buyLottoCount) {
        StringBuilder builder = new StringBuilder();
        builder.append(buyLottoCount);
        builder.append("개를 구매했습니다.");
        System.out.println(builder.toString());
    }

    public static void outputLottoNumbers(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(getLottoNumbers(lotto));
        builder.append("]");
        System.out.println(builder.toString());
    }

    private static String getLottoNumbers(Lotto lotto) {
        return lotto.getLotto()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
