package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;

public class LottoParser extends Parser {
    /**
     * Description: Parse List&lt;Integer&gt; to List&lt;LottoNumber&gt;
     */
    public static List<LottoNumber> parseIntListToLottoNumberList(List<Integer> args) {
        return args.stream()
                .map(LottoNumber::of)
                .toList();
    }

    /**
     * Description: Parse List&lt;LottoNumber&gt; to String
     */
    public static String parseLottoNumberListToString(LottoNumbers args) {
        return Arrays.toString(parseLottoNumbersToIntArray(args));
    }

    /**
     * Description: Parse LottoNumbers to List&lt;Integer&gt;
     */
    private static Object[] parseLottoNumbersToIntArray(LottoNumbers args) {
        return args.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .toArray();
    }

    /**
     * Description: Parse List&lt;Integer&gt; to Lotto
     */
    public static LottoNumbers parseIntListToLotto(List<Integer> args) {
        return new LottoNumbers(parseIntListToLottoNumberList(args));
    }
}
