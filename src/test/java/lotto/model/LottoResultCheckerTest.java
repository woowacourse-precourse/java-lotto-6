package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultCheckerTest {
    @DisplayName("당첨 번호와 중복된 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void testWhenBonusNumberDuplicateWinningNumbers() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.createWinningNumbers("1,2,3,4,5,6");

        IllegalArgumentException bonusNumberException =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> lottoResultChecker.createBonusNumber("6"));
        assertThat(bonusNumberException.getMessage()).contains("[ERROR]");
    }

    @DisplayName("적절한 보너스 번호 입력 시 예외가 발생하지 않는다.")
    @Test
    void testWhenBonusNumberIsValid() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.createWinningNumbers("1,2,3,4,5,6");

        Assertions.assertDoesNotThrow(() -> lottoResultChecker.createBonusNumber("20"));
    }

    @DisplayName("로또가 주어지면 일치한 당첨 번호 갯수에 맞춰서 정해진 등수의 결과를 나타낸다.")
    @Test
    void testShowLottoResults() {
        Client client = new Client();
        client.addLotto(new Lotto(List.of(1,2,3,4,5,6)));
        client.addLotto(new Lotto(List.of(1,2,3,10,15,20)));
        client.addLotto(new Lotto(List.of(1,2,3,4,10,35)));
        client.addLotto(new Lotto(List.of(1,2,3,4,5,16)));
        client.addLotto(new Lotto(List.of(11,12,13,14,15,16)));
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.createWinningNumbers("1,2,3,4,5,6");
        lottoResultChecker.createBonusNumber("16");

        List<Integer> result = lottoResultChecker.showLottoResults(client.getLottos());

        assertThat(result).isEqualTo(List.of(1,1,1,0,1,1));
    }
}
