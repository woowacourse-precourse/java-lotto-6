package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoScoreChecker;
import lotto.utils.StringChanger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoScoreCheckerTest {
    @DisplayName("당첨 번호 입력이 숫자가 아니면 예외를 발생시킨다.") // 이외 검증은 Lotto클래스에서
    @Test
    void inputNotNumbers() {
        LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
        String invalidUserInput = "1,2,3,4,a,b";
        List<String> invalidInput = makeInputList(invalidUserInput);
        assertThatThrownBy(() -> lottoScoreChecker.setWinningLotto(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1등 로또 생성 테스트")
    @Test
    void 당첨_로또_생성_테스트() {
        LottoScoreChecker lottoScoreChecker = new LottoScoreChecker();
        String userInput = "1, 2, 3, 4, 5, 6 ";
        List<String> validInput = makeInputList(userInput);
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        assertThatCode(() -> lottoScoreChecker.setWinningLotto(validInput))
                .doesNotThrowAnyException();
        assertThat(lottoScoreChecker.getWinningLotto().showNumbers()).isEqualTo(lotto.showNumbers());
    }

    private List<String> makeInputList(String userInput) {
        return new ArrayList<>(StringChanger.stringToTrimmedStringList(userInput));
    }


}
