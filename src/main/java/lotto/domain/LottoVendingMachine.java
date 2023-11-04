package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoVendingMachine {
    public List<Lotto> buyLotto(Integer money) {
        Integer ticketCount = determineNumberOfLottoTicketsForAmount(money);

        return Stream.generate(this::generateLotto)
                .limit(ticketCount)
                .collect(Collectors.toList());
    }
    private Lotto generateLotto() {
        List<Integer> numbers = pickNumbers();
        return Lotto.of(numbers);
    }

    private Integer determineNumberOfLottoTicketsForAmount(Integer money) {
        isEndWithLottoPrice(money);
        return money / LottoConstants.LOTTO_PRICE.getValue();
    }

    private void isEndWithLottoPrice(Integer number) {
        if (number % LottoConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("금액은 1000단위로 입력하셔야합니다.");
        }
    }

    private List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER_OF_LOTTO.getValue(),
                LottoConstants.MAX_NUMBER_OF_LOTTO.getValue(),
                LottoConstants.LOTTO_NUMBER_COUNT.getValue());
    }
}
