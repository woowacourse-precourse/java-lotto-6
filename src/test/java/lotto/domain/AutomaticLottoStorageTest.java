package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.common.Constant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutomaticLottoStorageTest {

    @DisplayName("자동 로또 저장소 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = { 1000, 2000, 3000, 4000, 5000 })
    void createAutomaticLottoStorage(Integer totalPrice) {
        // Arrange & Act
        AutomaticLottoStorage automaticLottoStorage = AutomaticLottoStorage.from(totalPrice);

        // Assert
        Assertions.assertEquals(
                totalPrice / Constant.LOTTO_TICKET_PRICE,
                automaticLottoStorage.getAutomaticLottos().size());
    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {500, 1500, 10500, 10050, 10005})
    void checkInvalidTotalPrice(Integer totalPrice) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> AutomaticLottoStorage.from(totalPrice));
    }

//    @Test
//    void showAutomaticLottosResult() {
//
//    }
//
//    @Test
//    void getTicketCount() {
//
//    }
}