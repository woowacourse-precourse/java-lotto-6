package lotto.domain.lotto;

import lotto.domain.proxy.PrizeHandler;
import lotto.utils.RandomGenerator;
import lotto.utils.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static lotto.utils.StringUtils.toInt;

public class Lottery {

    private final Payment payment;
    private final List<Lotto> lottos;

    private Lottery(Payment payment, List<Lotto> lottos) {
        this.payment = payment;
        this.lottos = lottos;
    }

    public static Lottery of(String payment, RandomGenerator randomGenerator) {
        Payment newPayment = Payment.of(toInt(payment));
        int lottoCount = newPayment.getLottoCount();

        List<Lotto> newLotto = setupLotto(randomGenerator, lottoCount);

        return new Lottery(newPayment, newLotto);
    }

    private static List<Lotto> setupLotto(RandomGenerator randomGenerator, int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.of(randomGenerator.getRandomNumbers()))
                .toList();
    }

    public static int matchingCount(Paper paper, Lotto lotto, boolean isBonus) {
        return paper.matchingLotto(lotto, isBonus);
    }

    public String getLottoCount() {
        return payment.toString();
    }

    public void calculate(Paper paper, PrizeHandler prizeHandler) {
        lottos.forEach(lotto -> prizeHandler.process(paper, lotto));
    }

    public int getAmount() {
        return payment.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(payment, lottery.payment) && Objects.equals(lottos, lottery.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment, lottos);
    }


    /**
     * 로또를 구매한 만큼의 로또 번호 (6)을 출력한다.
     * ex) payment가 3000원이면 6개의 로또 번호를 묶음으로 3 개 출력한다.
     * [1, 2, 3, 4, 5, 6]
     * [1, 2, 3, 4, 5, 6]
     * [1, 2, 3, 4, 5, 6]
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        lottos.forEach(lotto -> stringJoiner.add(lotto.toString()));
        return stringJoiner + "\n";
    }
}
