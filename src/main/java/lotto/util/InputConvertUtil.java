package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConvertUtil {

    public static List<String> lottoNumberToLottoList(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(",");
        return Arrays.asList(lottoNumbers);
    }

    public static List<Integer> lottoNumberToIntegerList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
