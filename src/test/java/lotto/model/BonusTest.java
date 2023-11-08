package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BonusTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createInputNonInteger() {
        String inputInteger = "12";
        String inputString = "string";
        String inputNull = "";


        // 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> new Bonus(inputInteger));

        // 문자 입력했을 때 예외 발생
        assertThatThrownBy(()->new Bonus(inputString))
                .isInstanceOf(IllegalArgumentException.class);

        // 입력이 비어있을 때 예외 발생
        assertThatThrownBy(()->new Bonus(inputNull))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 범위를 넘어가면 예외가 발생한다.")
    @Test
    void createInputOutRanged() {
        String inputInteger = "12";
        String inputInteger2 = "46";
        String inputInteger3 = "10000000000";

        // 범위 안의 숫자 입력했을 때 예외 미발생
        assertThatNoException().isThrownBy(() -> new Bonus(inputInteger));

        // 범위 밖의 입력했을 때 예외 발생
        assertThatThrownBy(()->new Bonus(inputInteger2))
                .isInstanceOf(IllegalArgumentException.class);

        // 범위 밖의 입력했을 때 예외 발생
        assertThatThrownBy(()->new Bonus(inputInteger3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 입력값이 주어지는 리스트에 이미 있는지 확인한다..")
    @Test
    void createInputDuplicated() {
        String inputTarget = "10";
        Bonus bonus = new Bonus(inputTarget);

        assertThat(bonus.checkMatchEachLotto(List.of(10,11,12,13,14))).isEqualTo(true);

    }



}
