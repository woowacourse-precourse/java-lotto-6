package lotto.configuration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.controller.LottoGameController;
import lotto.repository.Repository;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.Test;

public class AppConfigTest {

    Config config = AppConfig.getInstance();

    @Test
    public void AppConfig가_싱글톤인지() {
        // Given && When
        Config config1 = AppConfig.getInstance();
        Config config2 = AppConfig.getInstance();

        // Then
        assertThat(config1).isInstanceOf(Config.class);
        assertThat(config1).isNotNull();
        assertThat(config2).isNotNull();
        assertThat(config1).isSameAs(config2);
    }

    @Test
    public void LottoGameController가_싱글톤인지() {
        // Given && When
        LottoGameController lottoGameController1 = config.lottoGameController();
        LottoGameController lottoGameController2 = config.lottoGameController();

        // Then
        assertThat(lottoGameController1).isInstanceOf(LottoGameController.class);
        assertThat(lottoGameController1).isNotNull();
        assertThat(lottoGameController2).isNotNull();
        assertThat(lottoGameController1).isSameAs(lottoGameController2);
    }

    @Test
    public void LottoGameService가_싱글톤인지() {
        // Given && When
        LottoGameService lottoGameService1 = config.lottoGameService();
        LottoGameService lottoGameService2 = config.lottoGameService();

        // Then
        assertThat(lottoGameService1).isInstanceOf(LottoGameService.class);
        assertThat(lottoGameService1).isNotNull();
        assertThat(lottoGameService2).isNotNull();
        assertThat(lottoGameService1).isSameAs(lottoGameService2);
    }

    @Test
    public void InputView가_싱글톤인지() {
        // Given && When
        InputView inputView1 = config.inputView();
        InputView inputView2 = config.inputView();

        // Then
        assertThat(inputView1).isInstanceOf(InputView.class);
        assertThat(inputView1).isNotNull();
        assertThat(inputView2).isNotNull();
        assertThat(inputView1).isSameAs(inputView2);
    }

    @Test
    public void OutputView가_싱글톤인지() {
        // Given && When
        OutputView outputView1 = config.outputView();
        OutputView outputView2 = config.outputView();

        // Then
        assertThat(outputView1).isInstanceOf(OutputView.class);
        assertThat(outputView1).isNotNull();
        assertThat(outputView2).isNotNull();
        assertThat(outputView1).isSameAs(outputView2);
    }

    @Test
    public void LottoGameRepository가_싱글톤인지() {
        // Given && When
        Repository repository1 = config.lottoGameRepository();
        Repository repository2 = config.lottoGameRepository();

        // Then
        assertThat(repository1).isInstanceOf(Repository.class);
        assertThat(repository1).isNotNull();
        assertThat(repository2).isNotNull();
        assertThat(repository1).isSameAs(repository2);
    }
}
