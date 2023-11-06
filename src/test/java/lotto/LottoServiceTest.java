package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    LottoStorage lottoStorage;
    LottoService lottoService;

    static Stream<Arguments> stringAndStringProvider() {
        return Stream.of(
                Arguments.of("1,10,오,11,15,16", "올바른 입력 형식이 아닙니다. 숫자를 입력해주세요."),
                Arguments.of("46,10,5,11,15,16", "1~45 사이의 숫자를 입력해주세요."),
                Arguments.of("0,10,5,11,15,16", "1~45 사이의 숫자를 입력해주세요."),
                Arguments.of("45,10,5,11,15,11", "중복이 포함되어 있습니다.")
        );
    }

    static Stream<Arguments> listAndBonusProvider() {
        return Stream.of(
                Arguments.of(List.of(45, 10, 5, 11, 15, 16, 30), Bonus.emptyBonus()),
                Arguments.of(List.of(45, 10, 5, 11, 15), Bonus.emptyBonus())
        );
    }

    @BeforeEach
    void setUp() {
        lottoStorage = new LottoStorage();
        lottoService = new LottoService(lottoStorage);
    }

    @Test
    @DisplayName("금액에 맞는 로또 수 만큼 로또를 생성한다.")
    void test_GenerateLotteriesSuccessful() {
        //given
        BigDecimal payment = new BigDecimal(5000);

        //when
        lottoService.generateLotteries(payment);

        //then
        List<Lotto> lotteries = lottoStorage.findAllLotteries();
        assertThat(lotteries).hasSize(5);
    }

    @ParameterizedTest(name = "{0}을 입력 시 출력 예외 문구 : {1}")
    @MethodSource("stringAndStringProvider")
    @DisplayName("당첨 번호가 잘못 됐을 때 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotNumbersFailed(String input, String expectedMessage) {
        //when
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> lottoService.generateJackpotNumbers(input));

        //then
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @ParameterizedTest(name = "{0}을 입력 받을 시 예외 발생")
    @ValueSource(strings = {"0", "46"})
    @DisplayName("보너스 번호가 잘못 됐을 때 IllegalArgumentException을 발생시킨다.")
    void test_GenerateBonusNumber(String input) {
        //when
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> lottoService.generateBonus(input));

        //then
        assertThat(exception.getMessage()).isEqualTo("1~45 사이의 숫자를 입력해주세요.");
    }

    @ParameterizedTest(name = "{0}을 입력 받을 시 예외 발생")
    @MethodSource("listAndBonusProvider")
    @DisplayName("당첨 로또를 저장을 실패하면 IllegalArgumentException을 발생시킨다.")
    void test_SaveJackpotLottoFailed(List<Integer> numbers, Bonus bonus) {
        //when
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> lottoService.saveJackpotLotto(numbers, bonus));

        //then
        assertThat(exception.getMessage()).isEqualTo("로또는 6개의 숫자로 되어있어야 합니다.");
    }

    @Test
    @DisplayName("당첨 로또 저장을 성공한다.")
    void test_SaveJackpotLottoSuccessful() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Bonus bonus = new Bonus(1);

        //when
        Lotto jackpotLotto = lottoService.saveJackpotLotto(numbers, bonus);

        //then
        Lotto foundLotto = lottoStorage.findJackpot()
                .get();
        assertThat(foundLotto).isEqualTo(jackpotLotto);
    }
}
