package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConvertUtil {

    private static final String NUMBER_SPLIT_REGEX = ",";

    public static List<String> lottoNumberToLottoList(String lottoNumber) {
        String[] lottoNumbers = lottoNumber.split(NUMBER_SPLIT_REGEX);
        return Arrays.asList(lottoNumbers);
    }

    public static List<Integer> lottoNumberToIntegerList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
