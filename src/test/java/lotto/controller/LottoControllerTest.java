package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {


    LottoController lottoController = new LottoController();
    List<Integer> values;
    List<Boolean> expected;
    @DisplayName("로또구입금액이 허용하는 최대 값보다 클때의 예외 처리를 테스트")
    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE,1,999})
    void 로또구입금액_최대값_테스트(int testValues) {
        assertTrue(lottoController.isPriceLowerThanMax(testValues));
    }
    @DisplayName("로또구입금액이 허용하는 최소 값보다 작을때의 예외 처리를 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,999})
    void 로또구입금액_최소값_테스트(int testValues) {
        assertTrue(lottoController.isPriceBiggerThanMin(testValues));
    }

    @DisplayName("로또구입금액이 천원 단위가 아닐 때의 예외 처리를 테스트")
    @Test
    void 로또구입금액_천원단위_테스트() {
        assertTrue(lottoController.isPriceModZero(1000));
        assertFalse(lottoController.isPriceModZero(1999));
        assertTrue(lottoController.isPriceModZero(2000));
        assertTrue(lottoController.isPriceModZero(400000));

    }
}