package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputServiceTest extends NsTest {
    private final List<String> LOTTO_NUMBERS = List.of("1","2","3","4","5","6");


    private final UserInputService userInputService = new UserInputService();



    @DisplayName("빈 문자열을 넣으면 False를 반환한다")
    @Test
    void 빈_문자열_입력_오류_테스트() {
        assertThat(userInputService.isNumber("")).isEqualTo(false);
    }


    @DisplayName("숫자가 아닌 값을 넣으면 False를 반환한다")
    @Test
    void 숫자가_아닌_잘못된_입력_테스트() {
        assertThat(userInputService.isNumber("일")).isEqualTo(false);
    }


    @DisplayName("1000으로 나누어지지 않는 숫자를 입력받으면 False를 반환한다")
    @Test
    void 약수_테스트() {
        assertThat(userInputService.checkDevisedBy1000("1001")).isEqualTo(false);
    }


    @DisplayName("입력이 이상하면 IllegalArgumentException이 발생")
    @Test
    void IllegalArgumentException_반환_테스트() {
        assertSimpleTest(() -> {
            run("1001");
            assertThatThrownBy(() -> userInputService.moneyInputRequest())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @DisplayName("유효한 숫자 입력할때까지 오류 반환")
    @Test
    void 유효한_숫자_입력_테스트() {
        assertSimpleTest(() -> {
            run("1001","a","1000");
            Integer money = userInputService.validMoneyInputRequest();
            assertThat(money).isEqualTo(1000);
        });
    }

    @DisplayName("빈 문자 파싱 가능 테스트")
    @Test
    void 빈_문자_테스트() {
        userInputService.parsingInputNumbers("");
    }

    @DisplayName("유효한 당첨 로또번호 입력할때까지 오류 반환")
    @Test
    void 유효한_당첨번호_입력_테스트() {
        assertSimpleTest(() -> {
            run("1,2","1,1,1,1,1,1","1,2,3,4,5,6");
            HashSet<Integer> winningNumbers = userInputService.validWinningNumbersInputRequest();
            assertThat(winningNumbers.size()).isEqualTo(6);
            assertThat(winningNumbers.contains(6)).isEqualTo(true);
        });
    }

    @DisplayName("당첨숫자가 숫자로만 이루어지지 않으면 false 반환")
    @Test
    void 숫자로만_구성_테스트() {
        assertThat(userInputService
                .consistOfNumberTest(List.of("1","2","삼","4","5","6")))
                .isEqualTo(false);
    }


    @DisplayName("당첨숫자가 중복되면 false 반환")
    @Test
    void 당첨숫자_중복확인_테스트() {
        assertThat(userInputService
                .sizeIsSixTest(List.of("1","2","3","4","5","5")))
                .isEqualTo(false);
    }


    @DisplayName("당첨숫자가 6개가 아니라면 false 반환")
    @Test
    void 당첨숫자_6개_테스트() {
        assertThat(userInputService
                .sizeIsSixTest(List.of("1","2","3","4","5")))
                .isEqualTo(false);
    }


    @DisplayName("로또 숫자범위 잘못입력하면 false 반환")
    @Test
    void 로또_45_이내_자연수_테스트() {
        assertThat(userInputService
                .numberInOneToFourtyFIve(List.of("0","2","3","4","5","6")))
                .isEqualTo(false);
    }


    @DisplayName("로또 숫자범위 잘못입력하면 false 반환")
    @Test
    void 로또_45_이내_자연수_테스트2() {
        assertThat(userInputService
                .numberInOneToFourtyFIve(List.of("46","2","3","4","5","6")))
                .isEqualTo(false);
    }


    @DisplayName("입력이 이상하면 IllegalArgumentException이 발생")
    @Test
    void IllegalArgumentException_반환_테스트2() {
        assertSimpleTest(() -> {
            run("10,가");
            assertThatThrownBy(() -> userInputService.winningNumbersInputRequest())
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @DisplayName("보너스 숫자가 기존 로또 번호와 겹치면 false 리턴")
    @Test
    void 보너스_숫자_겹침_테스트() {
        assertThat(userInputService
                .bonusNumberNotInLottoNumbers(new HashSet<>(List.of(1,2,3,4,5,6)),1))
                .isEqualTo(false);
    }


    @Override
    protected void runMain() {

    }
}
