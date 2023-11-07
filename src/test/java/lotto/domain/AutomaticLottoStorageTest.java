package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.common.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutomaticLottoStorageTest extends NsTest {

    @DisplayName("자동 로또 저장소 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 2000, 3000, 4000, 5000 })
    void createAutomaticLottoStorage(Integer totalPrice) {
        // Arrange & Act
        AutomaticLottoStorage automaticLottoStorage = AutomaticLottoStorage.from(totalPrice);

        // Assert
        Assertions.assertEquals(
                automaticLottoStorage.getTicketCount(),
                automaticLottoStorage.getAutomaticLottos().size());
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {500, 1500, 10500, 10050, 10005})
    void checkInvalidTotalPrice(Integer totalPrice) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> AutomaticLottoStorage.from(totalPrice));
    }

    @DisplayName("발행한 로또 수량 및 로또 번호 출력 테스트")
    @Test
    void showAutomaticLottosResult() {
        // Assert
        assertAll(() -> {
            run();
            Assertions.assertTrue(output().contains("8개를 구매했습니다."));
        });
    }

    @Override
    protected void runMain() {
        AutomaticLottoStorage automaticLottoStorage = AutomaticLottoStorage.from(8000);
        automaticLottoStorage.showAutomaticLottosResult();
    }
}