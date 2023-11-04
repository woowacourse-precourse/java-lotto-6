package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.repository.Lotto;
import lotto.enums.LottoRule;
import lotto.enums.UserInterfaceMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoPublishServiceTest {

    LottoPublishService lottoPublishService;

    @BeforeEach
    void setup() {
        lottoPublishService = LottoPublishService.getInstance();
        lottoPublishService.clearPublishedLottoNumbers();
    }

    @DisplayName("중복되지_않는_6개의_숫자_생성")
    @RepeatedTest(5)
    void 중복되지_않는_6개의_숫자_생성() {
        // give
        lottoPublishService.lottoPublish("2000");
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        // when
        Set<Integer> dinstinctLottos = new HashSet<>(lottos.get(0).getNumbers());
        // then
        assertThat(dinstinctLottos.size()).isEqualTo(LottoRule.LOTTO_MAX_COUNT.getValue());
    }

    @Test
    void 구매_복권의_게임수_테스트() {
        // give
        lottoPublishService.lottoPublish("5000");
        Integer lottoPublishedSize = 5;
        // when
        List<Lotto> lottos = lottoPublishService.getPublishedLottoNumbers();
        // then
        assertThat(lottos.size()).isEqualTo(lottoPublishedSize);
    }

    @Test
    void 잘못된_형식의_구매금액() {
        assertThatThrownBy(() ->lottoPublishService.lottoPublish("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                        LottoRule.START.getValue(), LottoRule.END.getValue()));

    }
}