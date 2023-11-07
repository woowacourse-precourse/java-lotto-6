package lotto.io;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoConstant;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class InputMapper {


    public PurchaseAmount toAmount(final String input) {
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public Lotto toWinningLotto(final String input) {
        List<Integer> numbers = Stream.of(input.split(LottoConstant.DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    public BonusNumber toBonusNumber(final String input) {
        return new BonusNumber(Integer.parseInt(input));
    }
}
