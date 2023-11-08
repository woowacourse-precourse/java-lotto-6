package lotto.domain.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.global.enums.ErrorMessage;
import lotto.global.enums.Regex;
import lotto.global.enums.Separator;
import lotto.domain.number.LottoNumber;
import lotto.global.exception.InvalidValueException;

public class ConvertService {

    public List<LottoNumber> stringToNormalNumberConverter(final String input) {
        return Stream.of(input.split(Separator.COMMA.toString()))
                .map(LottoNumber::pickNormalNumber)
                .collect(Collectors.toList());
    }

    public LottoNumber stringToBonusNumberConverter(final String input){
        return LottoNumber.pickBonusNumber(input);
    }

    public int stringToIntegerConverter(final String input){
        return Integer.parseInt(input);
    }
}
