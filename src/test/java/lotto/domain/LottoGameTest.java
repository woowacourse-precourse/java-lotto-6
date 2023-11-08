package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

	@DisplayName("입력된 당첨번호가 로또 형식에 어긋나면 예외가 발생한다.")
    @Test
    void validateLottoFormat() {
        List<Integer> case1 = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> case2 = List.of(1, 2, 3, 4, 5, 50);
        List<Integer> case3 = List.of(1, 2, 3, 4, 5, 6, 7);

        Throwable result1 = catchThrowable(() -> {
            new LottoGame(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            new LottoGame(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            new LottoGame(case3);
        });

        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("입력된 보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateDuplicate() {
		String case1 = "문자";
		String case2 = "50";

        Throwable result1 = catchThrowable(() -> {
            LottoGame.validateBonusNumber(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            LottoGame.validateBonusNumber(case2);
        });

        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("입력된 보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void containingNumber() {
		new LottoGame(List.of(1, 2, 3, 4, 5, 6));
		String case1 = "1";

        Throwable result1 = catchThrowable(() -> {
            LottoGame.validateBonusNumber(case1);
        });

        assertThat(result1).isInstanceOf(IllegalArgumentException.class);
    }

}
