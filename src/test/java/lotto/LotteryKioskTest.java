package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LotteryKiosk;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LotteryKioskTest {
    @DisplayName("1000으로 나누어 떨어지지 않으면 예외를 발생한다")
    @Test
    void throwExceptionWhenDoesNotDivideBy1000() {
        LotteryKiosk lotteryKiosk = new LotteryKiosk(new LottoGenerator());
        int money = 500;
        assertThatThrownBy(() -> lotteryKiosk.issueCount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자는 1000원 단위로 구입할 수 있습니다.");

        int money2 = 2300;
        assertThatThrownBy(() -> lotteryKiosk.issueCount(money2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사용자는 1000원 단위로 구입할 수 있습니다.");
    }

    @DisplayName("3000원을 입력하면 3개의 로또가 발행된다(issueCount테스트)")
    @Test
    void publishLottosWhenInputBy3000() {
        LotteryKiosk lotteryKiosk = new LotteryKiosk(new LottoGenerator());

        assertThat(lotteryKiosk.issueCount(3000))
                .isEqualTo(3);
    }


    @DisplayName("정상적으로 금액을 입력하면 로또 발급권이 발행된다(publish테스트)")
    @Test
    void normalLottoListByLottos() {
        LotteryKiosk lotteryKiosk = new LotteryKiosk(new LottoGenerator());
        Lottos lottos = lotteryKiosk.publish(15000);

        assertThat(lottos.getSize())
                .isEqualTo(15);
    }

    @DisplayName("발행한 로또를 추가하거나 수정하려고하면 예외를 발생시킨다")
    @Test
    void throwExceptionWhenModifyLottoBundle() {
        LotteryKiosk lotteryKiosk = new LotteryKiosk(new LottoGenerator());
        Lottos lottos = lotteryKiosk.publish(15000);
        List<Lotto> lottoBundle = lottos.lottoBundle();
        assertThatThrownBy(
                () -> lottoBundle.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}
