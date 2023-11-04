package lotto.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningTest {

    public static final String errorPrefix="[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,,4,5,6","1,2,3,4,5,6,","1,2,3,4,5","1,2,3,사,5,6","","1,2,3, 4,5,6","1,2,3,4,5,46"})
    void Winning_생성_WinningNumbers_예외_테스트(String winningNumbers){
        //given
        String bonusNumber = "7";

        assertThatThrownBy(()->{
                new Winning(winningNumbers,bonusNumber);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(errorPrefix);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","46","한글","","2 1","4,"})
    void Winning_생성_BonusNumber_예외_테스트(String bonusNumber){
        //given
        String winningNumbers = "1,2,3,4,5,6";

        assertThatThrownBy(()->{
                new Winning(winningNumbers,bonusNumber);
            }
                ).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(errorPrefix);
    }

    @Test
    void Winning_생성_유효한_값_테스트(){
        //given
        String winningNumbersString = "1,2,3,4,5,6";
        String bonusNumber = "7";
        List<Integer> targetNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Winning winning = new Winning(winningNumbersString, bonusNumber);
        List<Integer> winningNumbers = winning.getWinningNumbers();
        assertThat(winningNumbers).isEqualTo(targetNumbers);
    }
}
