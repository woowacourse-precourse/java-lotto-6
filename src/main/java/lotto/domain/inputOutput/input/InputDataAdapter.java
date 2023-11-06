package lotto.domain.inputOutput.input;

import lotto.constants.LottoConstants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputDataAdapter {
    public List<Integer> transformLottoDrawNumber(String lottoDrawNumber) throws IllegalArgumentException {
        String[] lottoDrawNumbers = lottoDrawNumber.split(",");

        String pattern = "^[0-9]+$";
        Pattern compiledPattern = Pattern.compile(pattern);
        for (String number : lottoDrawNumbers) {
            Matcher matcher = compiledPattern.matcher(number);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }

        List<Integer> lottoDrawNumbersInteger = Arrays
                .stream(lottoDrawNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if( lottoDrawNumbersInteger.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다.");
        }

        if(isNumbersOutOfRange(lottoDrawNumbersInteger)){
            throw new IllegalArgumentException("[ERROR] 1~45 숫자만 입력 해주세요.");
        }
        return lottoDrawNumbersInteger;
    }
    private boolean isNumbersOutOfRange(List<Integer> numbers) {
        return numbers
                .stream()
                .anyMatch(number
                        -> number < LottoConstants.MIN_NUMBER_OF_LOTTO.getValue()
                        || number > LottoConstants.MAX_NUMBER_OF_LOTTO.getValue());
    }
    public Integer transformLottoDrawBonusNumber(String lottoDrawBonusNumber) throws IllegalArgumentException {
        if (lottoDrawBonusNumber.matches("\\d+")) {
            return Integer.parseInt(lottoDrawBonusNumber);
        }

        else {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }


}
