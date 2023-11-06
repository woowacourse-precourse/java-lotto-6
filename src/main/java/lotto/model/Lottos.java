package lotto.model;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomUtil;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(PaymentAmount paymentAmount) {
        int numberOfLotto = computeNumberOfLotto(paymentAmount.getPrice());
        lottos = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> new Lotto(RandomUtil.createRandomNumbersInRange(1, 45, 6))).toList();
    }

    private int computeNumberOfLotto(int price) {
        return price / LOTTO_PRICE;
    }

    @Override
    public String toString() {
        StringBuilder lottosInfo = new StringBuilder();
        lottosInfo.append(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), lottos.size()));
        lottos.forEach(lotto -> lottosInfo.append(lotto.toString()).append('\n'));
        return lottosInfo.toString();
    }
}
