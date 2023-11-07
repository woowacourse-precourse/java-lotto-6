package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AutomaticLottoStorageTest {

//    @DisplayName("자동 로또 저장소 객체 생성 테스트")
//    @Test
//    void createAutomaticLottoStorage() {
//        AutomaticLottoStorage.from();
//    }

    @DisplayName("로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = { 500, 1500, 10500, 10050, 10005 })
    void createAutomaticLottoStorage(Integer totalPrice) {
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