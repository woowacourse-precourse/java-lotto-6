package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Info;
import lotto.model.Lotto;
import lotto.service.Discriminator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class DiscriminatorTest {
    private Discriminator discriminator;

    @BeforeEach
    void init() {
        discriminator = new Discriminator();
        discriminator.setBonus(new Bonus(7));
        discriminator.setCorrectNumbers(new Lotto(List.of(1,2,3,4,5,6)));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 수익률_계산_테스트() {
        discriminator.discriminate(List.of(1,2,3,4,5,6));

        assertThat(discriminator.getProfitRate(1000).getProfitRate())
                .isEqualTo(200000000.0);
    }

}
