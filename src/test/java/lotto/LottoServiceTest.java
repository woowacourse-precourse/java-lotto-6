package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoStorage lottoStorage;
    LottoService lottoService;

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

    @Test
    @DisplayName("당첨 로또를 생성할 때 숫자가 아닌 수가 포함되면 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotFailed_NotNumber() {
        //given
        String input = "1,10,오,11,15,16";

        //when & then
        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 입력 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("당첨 로또를 생성할 때 1보다 작으면 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotFailed_ContainingNumberUnder1() {
        //given
        String input = "0,10,5,11,15,16";

        //when & then
        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("당첨 로또를 생성할 때 45보다 크면 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotFailed_ContainingNumberOver45() {
        //given
        String input = "46,10,5,11,15,16";

        //when & then
        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자를 입력해주세요.");
    }

//    @Test
//    @DisplayName("6개보다 많은 숫자면 IllegalArgumentException을 발생시킨다.")
//    void test_GenerateJackpotFailed_NumbersMoreThan6() {
//        //given
//        String input = "45,10,5,11,15,16,30";
//
//        //when & then
//        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("로또는 6개의 숫자로 되어있어야 합니다.");
//    }

//    @Test
//    @DisplayName("6개보다 적은 숫자면 IllegalArgumentException을 발생시킨다.")
//    void test_GenerateJackpotFailed_NumbersLessThan6() {
//        //given
//        String input = "45,10,5,11,15";
//
//        //when & then
//        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("로또는 6개의 숫자로 되어있어야 합니다.");
//    }

//    @Test
//    @DisplayName("중복이 포함되어 있으면 IllegalArgumentException을 발생시킨다.")
//    void test_GenerateJackpotFailed_NumbersNotDistinct() {
//        //given
//        String input = "45,10,5,11,15,11";
//
//        //when & then
//        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("중복이 포함되어 있습니다.");
//    }

    @Test
    @DisplayName("보너스 번호가 1보다 작으면 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotFailed_BonusNumberUnder1() {
        //given
        String input = "0";

        //when & then
        assertThatThrownBy(() -> lottoService.generateJackpotNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("보너스 번호가 45보다 크면 IllegalArgumentException을 발생시킨다.")
    void test_GenerateJackpotFailed_BonusNumberOver45() {
        //given
        String input = "46";

        //when & then
        assertThatThrownBy(() -> lottoService.generateBonus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~45 사이의 숫자를 입력해주세요.");
    }
}
