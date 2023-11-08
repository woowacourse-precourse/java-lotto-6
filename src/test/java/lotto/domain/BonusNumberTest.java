package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private static Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto("1,2,3,4,5,6");
    }

    @DisplayName("보너스 번호 - 정상 입력")
    @Test
    void bonusCorrectInput() {
        String input = "10";
        BonusNumber bonusNumber = new BonusNumber(input, lotto);

        assertEquals(Integer.parseInt(input), bonusNumber.getBonusNumber());
    }

    @DisplayName("보너스 번호 - NULL 입력")
    @Test
    void bounsNullInput() {
        String input = "";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 문자 포함 입력")
    @Test
    void bounsCharacterInclude() {
        String input = "12df";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 문자만 입력")
    @Test
    void bounsOnlyCharacter() {
        String input = "df";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 로또 숫자 범위 초과 입력")
    @Test
    void bounsOverRange() {
        String input = "46";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 로또 숫자 범위 미만 입력")
    @Test
    void bounsUnderRange() {
        String input = "0";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 공백 포함 입력")
    @Test
    void bounsSpaceInclude() {
        String input = "12 ";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 공백만 입력")
    @Test
    void bounsOnlySpace() {
        String input = " ";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 쉼표로 나눠서 입력")
    @Test
    void bounsSeparatedNumber() {
        String input = "1,2,3";

        assertThatThrownBy(() -> new BonusNumber(input, lotto)).isInstanceOf(IllegalArgumentException.class);
    }
}