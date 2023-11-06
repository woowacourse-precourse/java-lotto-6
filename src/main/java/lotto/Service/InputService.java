package lotto.Service;

import lotto.domain.LottoEnum;

public class InputService {

    public Integer getStringPriceToInt(String line) {
        return Integer.parseInt(line) / LottoEnum.LOTTO_PRICE.getStatus();
    }

}
