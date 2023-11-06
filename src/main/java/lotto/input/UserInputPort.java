package lotto.input;

import lotto.domain.LottoAnswer;

public interface UserInputPort {
    int getLottoBuyPrice();
    LottoAnswer getLottoAnswer();
}
