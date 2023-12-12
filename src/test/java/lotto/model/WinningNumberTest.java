package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WinningNumberTest {

    @DisplayName("[Success]보너스 번호 입력에 성공합니다. ")
    @Test
    void createBonusNumber(){
        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(lottoWinningNumber);
        String bonusNumber = "7";
        assertDoesNotThrow(() -> winningNumber.setBonusNumber(bonusNumber));
    }

    @DisplayName("입력 번호에서 유효하지 않은 숫자가 존재할 경우")
    @Test
    void createWinningNumberOverRange(){
        List<Integer> lottoWinningNumber = List.of(1,2,3,100,5,6);
        assertThatThrownBy(() -> new WinningNumber(lottoWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);;
    }

    @DisplayName("보너스 번호가 입력 번호와 일치할 경우")
    @Test
    void createBonusMatchWinningNumber(){
        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(lottoWinningNumber);
        String bonusNumber = "6";
        assertThatThrownBy(() -> winningNumber.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);;
    }

    @DisplayName("보너스 번호가 범위에서 벗어날 경우")
    @Test
    void createBonusOverRange(){
        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(lottoWinningNumber);
        String bonusNumber = "100";
        assertThatThrownBy(() -> winningNumber.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);;
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우")
    @Test
    void createBonusNotNumber(){
        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,6);
        WinningNumber winningNumber = new WinningNumber(lottoWinningNumber);
        String bonusNumber = "안녕";
        assertThatThrownBy(() -> winningNumber.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);;
    }
}
