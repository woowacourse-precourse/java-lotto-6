package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import message.ErrorMessages;
import utils.Converter;

public class LottoVendor {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int COUNT = 6;
    private static final int LOTTO_AMOUNT = 1000;

    public LottoVendor(String purchaseAmount) {
        validationDivide(Converter.stringToInt(purchaseAmount));
    }

    public int getLottoAmount() {
        return LOTTO_AMOUNT;
    }

    public void validationDivide(int purchaseAmount) {
        if (purchaseAmount % LOTTO_AMOUNT > 0) {
            throw new IllegalArgumentException(ErrorMessages.CAN_NOT_DIVIDE);
        }
    }

    public int divideByAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_AMOUNT;
    }

    public LottoRepository publishLotto(String purchaseAmount) {
        int lottoCount = divideByAmount(Converter.stringToInt(purchaseAmount));
        return LottoRepository.lottosOf(createLottos(lottoCount));
    }

    public List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0, lottoCount).mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
        return new Lotto(numbers);
    }

}
