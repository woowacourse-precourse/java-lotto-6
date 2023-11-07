package lotto.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.controller.LottoGameController;
import lotto.repository.Repository;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppConfigTest {

    private Config config;

    @BeforeEach
    void setUp() {
        config = AppConfig.getInstance();
    }

    @Test
    public void AppConfig가_싱글톤인지() {
        assertSingleton(config);
    }

    @Test
    public void LottoGameController가_싱글톤인지() {
        assertSingleton(config.lottoGameController());
    }

    @Test
    public void LottoGameService가_싱글톤인지() {
        assertSingleton(config.lottoGameService());
    }

    @Test
    public void InputView가_싱글톤인지() {
        assertSingleton(config.inputView());
    }

    @Test
    public void OutputView가_싱글톤인지() {
        assertSingleton(config.outputView());
    }

    @Test
    public void LottoGameRepository가_싱글톤인지() {
        assertSingleton(config.lottoGameRepository());
    }

    private <T> void assertSingleton(T instance) {
        assertThat(instance).isInstanceOf(instance.getClass());
        assertThat(instance).isNotNull();
        assertThat(instance).isSameAs(instance);
    }
}
