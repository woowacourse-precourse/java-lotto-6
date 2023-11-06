package lotto.domain.inputOutput.input;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputDataAdapter {
    public List<Integer> transformLottoDrawNumber(String lottoDrawNumber){
        String[] lottoDrawNumbers = lottoDrawNumber.split(",");

        String pattern = "^[0-9]+$";
        Pattern compiledPattern = Pattern.compile(pattern);
        for (String number : lottoDrawNumbers){
            Matcher matcher = compiledPattern.matcher(number);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }

        return Arrays
                .stream(lottoDrawNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer transformLottoDrawBonusNumber(String lottoDrawBonusNumber) {
        if (lottoDrawBonusNumber.matches("\\d+")) {
            return Integer.parseInt(lottoDrawBonusNumber);
        } else {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }


}
