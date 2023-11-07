package lotto.service;

import lotto.Application;
import lotto.domain.Buyer;
import lotto.repository.LotteryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.NsTestStudy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static study.AssertionsStudy.assertRandomUniqueNumbersInRangeTest;

class LotteryServiceTest extends NsTestStudy {
    private LotteryRepository lotteryRepository = LotteryRepository.getInstance();
    private LotteryService lotteryService = LotteryService.getInstance();


    @Override
    @BeforeEach
    public void init() {
        super.init();
        lotteryRepository.initBuyer();
    }

    @DisplayName("1000원 미만일 시 예외 발생")
    @Test
    void lottoPayment_1000원_미만일_시_예외상황() {
        String input = "999";
        Assertions.assertThatThrownBy(() -> lotteryService.lottoPayment(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않을 시 예외 발생")
    @Test
    void lottoPayment_1000원으로_나누어떨어지지_않을_시_예외상황() {
        String input = "1999";
        Assertions.assertThatThrownBy(() -> lotteryService.lottoPayment(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 희망 금액이 1000원으로 나누어 떨어질 때 정상 작동")
    @Test
    void lottoPayment_1000원으로_나누어떨어질_때_정상작동() {
        String input = "2000";
        lotteryService.lottoPayment(input);
        Buyer buyer = lotteryRepository.getBuyer();
        Assertions.assertThat(buyer.getNumberOfLottery()).isEqualTo(2000 / 1000);
    }

    @DisplayName("로또 번호에 중복이 있을 때 예외 발생")
    @Test
    void saveLottoNumbers_로또_번호에_중복이_있을_때_예외발생() {
        String input = "1,2,3,4,5,5";

        Assertions.assertThatThrownBy(() -> lotteryService.saveLottoNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이의 번호가 아닐 때 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,57", "1,2,3,4,5,0"}, delimiter = ':')
    void saveLottoNumbers_로또_번호가_1에서_45_사이의_번호가_아닐_때_예외발생(String input) {
        Assertions.assertThatThrownBy(() -> lotteryService.saveLottoNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아닐 때 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"abc", "가나다", "!@#"})
    void saveLottoNumbers_로또_번호가_숫자가_아닐_때_예외발생(String input) {
        Assertions.assertThatThrownBy(() -> lotteryService.saveLottoNumbers(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 중복이 있을 때 예외 발생")

    @Test
    void saveBonusNumbers_보너스_번호와_로또_번호에_중복이_있을_때_예외발생() {
        String lottoNumbers = "1,2,3,4,5,6";
        String bonusNumber = "1";

        lotteryService.saveLottoNumbers(lottoNumbers);
        Assertions.assertThatThrownBy(() -> lotteryService.saveBonusNumber(bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 번호가 아닐 때 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"57", "0"}, delimiter = ':')
    void saveBonusNumbers_보너스_번호가_1에서_45_사이의_번호가_아닐_때_예외발생(String input) {
        Assertions.assertThatThrownBy(() -> lotteryService.saveBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닐 때 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"a", "가", "!"})
    void saveBonusNumbers_보너스_번호가_숫자가_아닐_때_예외발생(String input) {
        Assertions.assertThatThrownBy(() -> lotteryService.saveBonusNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불 금액에 따라 정상적인 구매 수량이 저장되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "100000:100", "153000:153"}, delimiter = ':')
    void getNumberOfLottery_지불금액을_입력_시_구매수량_정상확인(String input, int expected) {
        lotteryService.lottoPayment(input);
        Buyer buyer = lotteryRepository.getBuyer();
        Assertions.assertThat(buyer.getNumberOfLottery()).isEqualTo(expected);
    }


    //구현 실패...
    @Test
    void printLottos() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    try {
                        lotteryService.lottoPayment("10000");
                        printLottos();
                    } finally {
                        close();
                    }
                    assertThat(output()).contains(
                            "10개를 구매했습니다.",
                            "[6, 8, 10, 20, 34, 37]",
                            "[8, 18, 23, 27, 36, 38]",
                            "[2, 14, 28, 30, 39, 45]",
                            "[4, 5, 9, 12, 18, 30]",
                            "[2, 14, 39, 42, 43, 44]",
                            "[12, 18, 21, 27, 38, 42]",
                            "[20, 21, 25, 33, 37, 39]",
                            "[1, 15, 27, 35, 37, 43]",
                            "[11, 30, 34, 37, 40, 45]",
                            "[1, 14, 22, 30, 36, 42]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 50%입니다."
                    );
                },
                List.of(6, 8, 10, 20, 34, 37),
                List.of(8, 18, 23, 27, 36, 38),
                List.of(2, 14, 28, 30, 39, 45),
                List.of(4, 5, 9, 12, 18, 30),
                List.of(2, 14, 39, 42, 43, 44),
                List.of(12, 18, 21, 27, 38, 42),
                List.of(20, 21, 25, 33, 37, 39),
                List.of(1, 15, 27, 35, 37, 43),
                List.of(11, 30, 34, 37, 40, 45),
                List.of(1, 14, 22, 30, 36, 42)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}