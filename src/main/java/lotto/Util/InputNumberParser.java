package lotto.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Exception.BonusNumberException;
import lotto.Exception.LottoNumberException;

public class InputNumberParser {
    private final LottoNumberException lottoNumberException = new LottoNumberException();
    private final BonusNumberException bonusNumberException = new BonusNumberException();

    public List<Integer> processLottoNumbers(String inputLottoNumbers) {
        lottoNumberException.LottoNumbersCase(inputLottoNumbers);
        List<Integer> lottoNumbers = Arrays.stream(inputLottoNumbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public int processBonusNumber(String inputBonusNumber) {
        bonusNumberException.BonusNumberCase(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    public static int StringToInt(String number) {
        return Integer.parseInt(number);
    }
}
