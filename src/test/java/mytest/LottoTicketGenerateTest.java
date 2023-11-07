package mytest;

import lotto.model.LottoTicketEntity;
import lotto.service.LottoTicketGenerate;
import lotto.service.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTicketGenerateTest {
    @Test
    void setLottoTicketNumberTest() {
        LottoTicketGenerate lottoTicketGenerate = new LottoTicketGenerate(1000);
        List<LottoTicketEntity> lottoTicketEntitys = lottoTicketGenerate.getLottoTicketEntities();

        assertNotNull(lottoTicketEntitys);

        // 6개의 숫자가 생성되었는지 확인
        assertEquals(6, lottoTicketEntitys.get(0).getLottoNumbers().size());
        // 1~45 사이의 숫자가 생성되었는지 확인
        for (int number : lottoTicketEntitys.get(0).getLottoNumbers()) {
            assertTrue(number >= 1 && number <= 45);
        }
        // 중복된 숫자가 있는지 확인
        assertEquals(6, new HashSet<>(lottoTicketEntitys.get(0).getLottoNumbers()).size());
    }

    @ParameterizedTest
    @MethodSource("overSizeLottoNumbers")
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 발생")
    void lottoByOverSizeTest(List<Integer> lottoNumbers) {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.lottoTicketValidate(lottoNumbers));
    }
    private static Stream<Arguments> overSizeLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.of(List.of(32, 18, 22, 34, 11, 6, 44))
        );
    }

    @ParameterizedTest
    @MethodSource("duplicateLottoNumbers")
    @DisplayName("중복된 숫자가 발생 시 예외 발생")
    void duplicateLottoTest(List<Integer> lottoNumbers) {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.lottoTicketValidate(lottoNumbers));
    }
    private static Stream<Arguments> duplicateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 3, 4, 5)),
                Arguments.of(List.of(11, 22, 35, 35, 44, 7)),
                Arguments.of(List.of(34, 34, 22, 34, 11, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("rangeLottoNumbers")
    @DisplayName("1 ~ 45 범위안에 없을 시 예외 발생")
    void rangeLottoTest(List<Integer> lottoNumbers) {
        assertThrows(IllegalArgumentException.class, () -> LottoValidator.lottoTicketValidate(lottoNumbers));
    }
    private static Stream<Arguments> rangeLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 11, 34, 56, 7, 8)),
                Arguments.of(List.of(77, 11, 2, 3, 4, 5)),
                Arguments.of(List.of(-1, 11, 2, 3, 4, 5)),
                Arguments.of(List.of(0, 11, 2, 3, 4, 5))
                );
    }

}
