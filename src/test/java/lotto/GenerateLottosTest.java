package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.UserLottos;
import lotto.service.GenerateLottosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GenerateLottosTest {
    @DisplayName("로또의 구매가격 확인")
    @Test
    void setBuyingPrice() {
        UserLottos lottos = new UserLottos();
        GenerateLottosService generateLottosService = new GenerateLottosService();

        generateLottosService.setBuyingPrice(lottos, "7000");

        assertThat(lottos.getBuyingPrice()).isEqualTo(7000);
    }

    @DisplayName("로또 구매 개수 확인")
    @Test
    void setAmmount() {
        UserLottos lottos = new UserLottos();
        GenerateLottosService generateLottosService = new GenerateLottosService();

        generateLottosService.setAmmount(lottos, "7000");

        assertThat(lottos.getAmmount()).isEqualTo(7);
    }

    @DisplayName("로또 생성이 제대로 됐는지 리스트의 사이즈로 확인")
    @Test
    void generateLottos() {
        UserLottos lottos = new UserLottos();
        lottos.setAmmount("7000");

        for (int i = 0; i < lottos.getAmmount(); i++) {
            lottos.setLottos();
        }

        assertThat(lottos.getLottos().size()).isEqualTo(7);
    }
}
