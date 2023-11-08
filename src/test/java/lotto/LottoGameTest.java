package lotto;

import lotto.controller.LottoGame;
import lotto.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    @Test
    @DisplayName("돈 단위 확인하기")
    void loopCountCheckTest(){
        int amount = 2000;
        LottoGame lottoGame = new LottoGame();
        boolean isTrue = lottoGame.loopCountCheck(amount);
        assertThat(isTrue).isTrue();
    }

    @Test
    @DisplayName("돈 단위 실패 테스트")
    void loopCountCheckFailTest(){
        int amount = 3400;
        LottoGame lottoGame = new LottoGame();
        boolean isFalse = lottoGame.loopCountCheck(amount);
        assertThat(isFalse).isFalse();
    }

    @Test
    @DisplayName("로또 번호 리스트로 변경하기")
    void userInputNumberTest(){
        String numbers = "1,2,3,4,5,6";
        LottoGame lottoGame = new LottoGame();
        String[] inputNumbers = lottoGame.userNumbers(numbers);
        List<Integer> checkNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> userInputNumbers = lottoGame.userInputNumbers(inputNumbers);
        for(int i = 0; i < userInputNumbers.size(); i++){
            assertThat(userInputNumbers.get(i)).isEqualTo(checkNumbers.get(i));
        }
    }

    @Test
    @DisplayName("로또 번호 리스트 변환 실패")
    void userInputNumberFailTest(){
        String numbers = "1,2,3,4,5,a";
        LottoGame lottoGame = new LottoGame();
        String[] inputNumbers = lottoGame.userNumbers(numbers);
        assertThatThrownBy(() -> lottoGame.userInputNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void inputBonusNumberTest(){
        String bonusNumber = "3";
        LottoGame lottoGame = new LottoGame();
        int bonus = lottoGame.inputBonusNumber(bonusNumber);
        assertThat(bonus).isEqualTo(3);
    }


}
