package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.config.AppConfig;
import lotto.domain.MatchedLottoCount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class PlayerServiceTest {

    private AppConfig appConfig = new AppConfig();

    @InjectMocks
    private final PlayerService playerService = appConfig.playerService();

    @Test
    @DisplayName(value = "로또 복권의 금액이 1,000원일 때 구입 금액에 알맞은 수량의 로또 복권을 구입하는지 확인")
    void purchaseLottoBy5000Won() {
        long buyingPrice = 5000;
        int quantity = (int) (buyingPrice / LOTTO_PRICE.getInfo());

        assertThat(playerService.purchaseLotto(buyingPrice).size()).isEqualTo(quantity).isEqualTo(5);
    }

    @Test
    @Disabled(value = "AppConfig 도입으로 Mock 객체를 삭제하여 원하는 로또 값을 대입할 수 없게 되어 테스트 불가능")
    @DisplayName(value = "로또 번호와 입력 값이 일치한 만큼 배열에 성공적으로 저장되는지 확인")
    void compareLottoNumbers() {
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        MatchedLottoCount matchedLottoCount = playerService.compareLottoNumbers(inputNumbers, bonusNumber);
        assertThat(matchedLottoCount.getPlaceCount(1)).isEqualTo(1);
    }

}