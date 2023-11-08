package lotto.utils;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    private static final LottoException lottoException = new LottoException();

    public static List<Integer> lottoNumbersParser(String inputLottoNumbers) {
        lottoException.validInputLottoNumbers(inputLottoNumbers);
        List<Integer> lottoNumbers = new ArrayList<>();
        Arrays.stream(inputLottoNumbers.split(","))
                .map(number -> lottoNumbers.add(Integer.parseInt(number)))
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
    public static int bonusNumberParser(String bonusNumber) {
        lottoException.validInputBonusNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
