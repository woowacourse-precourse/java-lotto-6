package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.NotValidGivenPriceError;
import util.LottoNumberGenerator;

public class LottoServiceImpl implements LottoService {

    private static final int NUMBER_OF_LOTTO_DIGITS = 6;
    private static final int START_LOTTO_NUMBER_RANGE = 1;
    private static final int END_LOTTO_NUMBER_RANGE = 45;

    @Override
    public List<Lotto> issueNewLotto(int price) {
        int issueCount = getNumberOfLottoToBeIssued(price);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator
                    .getRandomNumber(START_LOTTO_NUMBER_RANGE, END_LOTTO_NUMBER_RANGE,
                            NUMBER_OF_LOTTO_DIGITS)));
        }
        return lottos;
    }

    private int getNumberOfLottoToBeIssued(int price) throws IllegalArgumentException {
        if (price == 0 || price % 1000 == 0) {
            throw new NotValidGivenPriceError();
        }
        return price / 1000;
    }
}
