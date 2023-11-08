package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.player.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModelAndViewConverterTest {
    private ModelAndViewConverter modelAndViewConverter;

    @BeforeEach
    void initGivenCondition() {
        modelAndViewConverter = ModelAndViewConverter.getModelAndViewConverter();
    }

    @DisplayName("[1,2,3,4,5,6] 로또 1개의 LottoBundleDto 를 변환하면 로또 개수 1개 및 로또 정보를 반환한다.")
    @Test
    void modelAndViesConverterTest_1() {
        LottoBundle lottoBundle = new LottoBundle();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoBundle.addLotto(lotto);

        modelAndViewConverter.addComponent(lottoBundle.makeLottoBundleDto());

        assertThat(modelAndViewConverter.getNumberOfLottoBundle()).isEqualTo(1);
        assertThat(modelAndViewConverter.getLottoMessages()).contains(lotto.toString());
    }

    @DisplayName("50.3 의 Profit 을 변환하면 50.3을 반환한다.")
    @Test
    void modelAndViesConverterTest_3() {
        Profit profit = new Profit(50.3);
        modelAndViewConverter.addComponent(profit);

        assertThat(modelAndViewConverter.getProfitMessage()).isEqualTo(50.3);
    }

}