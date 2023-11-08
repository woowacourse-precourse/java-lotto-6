package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.AppConfig;
import lotto.utils.generator.CustomRandomNumberGenerator;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    private static final String PROVIDER_PATH = "lotto.domain.lotto.provider.LottosTestProvider#";

    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomRandomNumberGenerator customRandomGenerator = APP_CONFIG.customRandomNumber;

    private Lottos generateLottos(final List<LottoDto> getLottos, final int count) {
        customRandomGenerator.initLottos(getLottos);
        return new Lottos(count, customRandomGenerator);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForGenerateTest")
    @DisplayName("로또는 주어진 개수만큼 생성되어야 한다.")
    void generateTicketsSizeCheckTest(final List<LottoDto> getLottos, final int count) {
        final Lottos tickets = generateLottos(getLottos, count);
        assertThat(tickets.getSize()).isEqualTo(count);
    }
}
