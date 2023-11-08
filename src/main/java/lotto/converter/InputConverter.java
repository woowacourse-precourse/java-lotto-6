package lotto.converter;

import static java.lang.Integer.parseInt;

import java.util.List;

public class InputConverter {

    public static Integer convertLottoMoney(String lottoMoneyInput) {
        return parseInt(lottoMoneyInput);
    }

    public static List<Integer> convertWinningLotto(String lottoNumberInput) {
        List<String> lottoNumbers = List.of(lottoNumberInput.split(","));
        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
