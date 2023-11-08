package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoNumberConvertor {

    private static final String DELIMITER = ",";

    public static Lotto convertToLotto(String lottoNumberInput) {
        try {
            List<Integer> lottoNumbers = getLottoNumbers(lottoNumberInput.split(DELIMITER));

            return Lotto.issueChooseNumbersLotto(lottoNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로만 구성 되어야 합니다. 다시 입력해주세요");
        }
    }

    public static LottoNumber convertToBonusNumber(String bonusNumberInput) {
        try {
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            return new LottoNumber(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 한 개의 숫자여야 합니다. 다시 입력해주세요");
        }
    }

    private static List<Integer> getLottoNumbers(String[] split) {
        return Arrays.stream(split)
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
