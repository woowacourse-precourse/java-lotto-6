package lotto.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
