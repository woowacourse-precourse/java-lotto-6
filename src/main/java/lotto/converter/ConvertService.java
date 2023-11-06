package lotto.converter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.Separator;
import lotto.number.LottoNumber;

public class ConvertService {


    public List<LottoNumber> stringToNormalNumberConverter(String input) {
        return Stream.of(input.split(Separator.COMMA.toString()))
                .map(LottoNumber::pickNormalNumber)
                .collect(Collectors.toList());
    }

    public LottoNumber stringToBonusNumberConverter(String input){
        return LottoNumber.pickBonusNumber(input);
    }
}
