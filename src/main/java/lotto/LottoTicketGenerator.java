package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Error.ErrorType;

public class LottoTicketGenerator {
    List<Integer> lottoNumber;
    int numberOfTicket;

    public LottoTicketGenerator(int amount) {
        validate(amount);
        numberOfTicket = amount / 1000;
    }

    public List<Integer> createLottoTicket() {
        lottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumber;
    }

    private void validate(int amount) {
        if (!(amount % 1000 == 0) || amount <= 0) {
            Error.errorMessage(ErrorType.INVALID_AMOUNT);
        }
    }

}
