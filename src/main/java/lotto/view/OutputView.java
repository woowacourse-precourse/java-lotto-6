package lotto.view;

import java.util.List;
import lotto.dto.LottoNumbers;

public final class OutputView {

    private static final String LOTTO_NUMBERS_STRING_PREFIX = "[";
    private static final String SEPARATE = ", ";
    private static final String LOTTO_NUMBER_STRING_SUFFIX = "]\n";

    private OutputView() {
    }

    public static void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(lottoNumbers.size()).append("개를 구매했습니다.\n");
        lottoNumbers
                .forEach(numbers -> makeLottoNumbersString(numbers, sb));
        System.out.println(sb);
    }

    private static void makeLottoNumbersString(LottoNumbers lottoNumbers, StringBuilder sb) {
        sb.append(LOTTO_NUMBERS_STRING_PREFIX);
        lottoNumbers.numbers()
                .forEach(number -> sb.append(number).append(SEPARATE));
        sb.delete(sb.length() - SEPARATE.length(), sb.length());
        sb.append(LOTTO_NUMBER_STRING_SUFFIX);
    }
}
