package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.util.StringParser;
import lotto.util.TypeConverter;

public class InputReader {
    public PurchaseAmount readPurchaseAmount() throws IllegalArgumentException {
        Integer amount = TypeConverter.StringToInteger(Console.readLine());
        return PurchaseAmount.from(amount);
    }

    public Lotto readLotto() throws IllegalArgumentException {
        List<String> strings = StringParser.parseToList(Console.readLine());
        List<LottoNumber> lottoNumbers = strings.stream()
                .map(TypeConverter::StringToInteger)
                .map(LottoNumber::from)
                .toList();
        return Lotto.from(lottoNumbers);
    }

    public LottoNumber readBonusNumber() throws IllegalArgumentException {
        Integer bonusNumber = TypeConverter.StringToInteger(Console.readLine());
        return LottoNumber.from(bonusNumber);
    }
}
