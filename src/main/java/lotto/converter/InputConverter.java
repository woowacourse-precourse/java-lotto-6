package lotto.converter;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class InputConverter {

    public static Integer convertLottoMoney(String lottoMoneyInput) {
        return parseInt(lottoMoneyInput);
    }

    public static Lotto convertWinningLotto(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));

        List<Integer> convertedLottoNumbers = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            convertedLottoNumbers.add(parseInt(lottoNumber));
        }

        return new Lotto(convertedLottoNumbers);
    }

    public static Integer convertBonusNumber(String bonusNumberInput) {
        return parseInt(bonusNumberInput);
    }
}
