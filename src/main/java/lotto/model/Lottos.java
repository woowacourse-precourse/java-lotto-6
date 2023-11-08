package lotto.model;

import static lotto.constant.LottoConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.START_LOTTO_NUMBER;
import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomUtil;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int paymentAmount, RandomUtil randomUtil) {
        int numberOfLotto = computeNumberOfLotto(paymentAmount);
        lottos = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> new Lotto(randomUtil.createRandomNumbersInRange(START_LOTTO_NUMBER, LAST_LOTTO_NUMBER
                        , LOTTO_NUMBER_COUNT))).toList();
    }

    private int computeNumberOfLotto(int price) {
        return price / LOTTO_PRICE;
    }

    @Override
    public String toString() {
        StringBuilder lottosInfo = new StringBuilder();
        lottosInfo.append(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), lottos.size())).append('\n');
        lottos.forEach(lotto -> lottosInfo.append(lotto.toString()).append('\n'));
        return lottosInfo.toString();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
