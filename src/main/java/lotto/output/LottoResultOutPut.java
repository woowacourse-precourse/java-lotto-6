package lotto.output;

import lotto.input.BonusNumberInPut;
import lotto.input.LottoNumberInPut;
import org.mockito.internal.matchers.Equals;

import java.util.*;

public class LottoResultOutPut {
    static final String WIN_STATISTIC = "당첨 통계";
    static final String BOUNDARY_LINE = "---";

    public static void lottoResult() {
        System.out.println(WIN_STATISTIC);
        System.out.println(BOUNDARY_LINE);
    }

    public static int winCount() {
        List<List<Integer>> randomNumbers = CreateLottoNumber.createLottoNumbers();
        int lottoCount = CreateLottoNumber.LottoCount();
        List<Integer> lottoNumbers = LottoNumberInPut.getLottoNumbers();
        int bonusNumber = BonusNumberInPut.bonusNumberResult();

        int numColumns = randomNumbers.get(lottoCount).size();
        int num = 0;
        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < randomNumbers.size(); j++) {
                if (Objects.equals(lottoNumbers.get(j), randomNumbers.get(j))) {
                    num += 1;
                }
                if (lottoNumbers.get(j) == bonusNumber) {
                    num += 1;
                }
            }
        }
        return num;
    }

    public static Map<Integer, Integer> mapResult() {
        List<Integer> numbers = List.of(5000, 50000, 1500000, 30000000, 2000000000);

        Map<Integer, Integer> numberMap = new HashMap<>();

        for (Integer number : numbers) {
            numberMap.put(number, 0);
        }
        return numberMap;
    }
}
