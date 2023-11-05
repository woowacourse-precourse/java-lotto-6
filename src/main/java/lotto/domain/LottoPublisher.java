package lotto.domain;

import static lotto.domain.LottoNumberConstant.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.randomnumber.RandomNumberPicker;

public class LottoPublisher {

    private final RandomNumberPicker randomNumberPicker;

    public LottoPublisher(RandomNumberPicker randomNumberPicker) {
        this.randomNumberPicker = randomNumberPicker;
    }

    public LottoTickets publish(int quantity) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int publishCount = 0; publishCount < quantity; publishCount++) {
            lottoTickets.add(new Lotto(pickLottoNumbers()));
        }

        return new LottoTickets(lottoTickets);
    }

    private List<Integer> pickLottoNumbers() {
        return this.randomNumberPicker.pickSixNumbersWithNotDuplicated(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

}
