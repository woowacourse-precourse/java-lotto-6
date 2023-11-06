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

    static Stream<Arguments> jackpotAndListAndLottoResultProvider() {
        Lotto jackpot = new Lotto(List.of(1, 2, 3, 4, 5, 6), new Bonus(10));
        return Stream.of(
                Arguments.of(jackpot, List.of(1, 2, 3, 7, 8, 9), LottoResult.THREE_MATCHING),
                Arguments.of(jackpot, List.of(1, 2, 3, 4, 8, 9), LottoResult.FOUR_MATCHING),
                Arguments.of(jackpot, List.of(1, 2, 3, 4, 5, 9), LottoResult.FIVE_MATCHING),
                Arguments.of(jackpot, List.of(1, 2, 3, 4, 5, 10), LottoResult.FIVE_AND_BONUS_MATCHING),
                Arguments.of(jackpot, List.of(1, 2, 3, 4, 5, 6), LottoResult.SIX_MATCHING)
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
        List<Lotto> lotteries = lottoStorage.findAllBoughtLotteries();
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

    @ParameterizedTest(name = "구매 로또가 {1}이면 {2}의 결과를 반환한다.")
    @MethodSource("jackpotAndListAndLottoResultProvider")
    @DisplayName("당첨 로또와 구매 로또를 비교해 결과를 반환한다.")
    void test_MatchLotteries_Results(Lotto jackpotLotto, List<Integer> numbers, LottoResult result) {
        //given
        Lotto lotto = new Lotto(numbers);
        lottoStorage.saveLotto(jackpotLotto);
        lottoStorage.saveLotto(lotto);

        //when
        LottoResults results = lottoService.matchLotteries();

        //then
        assertThat(results.get(0)).isEqualTo(result);
    }

    @Test
    @DisplayName("구매 로또 개수만큼 결과를 반환한다.")
    void test_MatchLotteries_ResultSize() {
        //given
        Lotto jackpotLotto = new Lotto(List.of(1,2,3,4,5,6), new Bonus(10));
        lottoStorage.saveLotto(jackpotLotto);
        Lotto firstLotto = new Lotto(List.of(1,2,3,7,8,9));
        Lotto secondLotto = new Lotto(List.of(1,2,3,4,7,8));
        lottoStorage.saveLotto(firstLotto);
        lottoStorage.saveLotto(secondLotto);

        //when
        LottoResults results = lottoService.matchLotteries();

        //then
        assertThat(results.size()).isEqualTo(2);
    }
}
