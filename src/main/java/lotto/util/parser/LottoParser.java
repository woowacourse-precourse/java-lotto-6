package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
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
     * Description: Parse List&lt;Integer&gt; to LottoNumbers
     */
    public static LottoNumbers parseIntListToLottoNumbers(List<Integer> args) {
        return new LottoNumbers(parseIntListToLottoNumberList(args));
    }

    /**
     * Description: Parse Lotto to Prize
     *
     * @param lotto
     * @param winningLotto
     * @return
     */
    public static Prize parseLottoToPrize(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean matchBonusNumber = winningLotto.isMatchBonusNumber(lotto);
        return Prize.of(matchCount, matchBonusNumber);
    }
}
