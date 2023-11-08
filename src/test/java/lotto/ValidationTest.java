package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    @DisplayName("입력한 금액이 숫자인지 확인한다.")
    @Test
    void validNumber() {
        assertThat(Validation.validNumber("12000")).as("숫자 입력값에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validNumber("12345")).as("숫자 입력값에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validNumber("f12")).as("문자가 섞였을 때에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validNumber("")).as("공백에 대한 반환값").isEqualTo(false);
    }

    @DisplayName("1000 단위의 숫자인지 확인한다.")
    @Test
    void validUnit() {
        assertThat(Validation.validUnit(1000)).as("1000 단위의 입력값에 대한 반환값").isEqualTo(true);
        assertThat(Validation.validUnit(1234)).as("1000 단위가 아닌 입력값에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validUnit(-1000)).as("음수에 대한 반환값").isEqualTo(false);
        assertThat(Validation.validUnit(0)).as("0에 대한 반환값").isEqualTo(false);
    }

    @DisplayName("당첨 번호를 정상적으로 입력했는지 확인한다.")
    @Test
    void validNumbers() {
        assertThat(Validation.validNumbers("1,2,3,4,5,6")).as("정상적인 값일 때의 반환값").isEqualTo(true);
        assertThat(Validation.validNumbers("1,2,3,e,5,6")).as("문자가 있을 때의 반환값").isEqualTo(false);
        assertThat(Validation.validNumbers("1,,3,4,5,6")).as("빈칸이 있을 때의 반환값").isEqualTo(true);
        assertThat(Validation.validNumbers("1 2 3 4 5 6")).as("쉼표가 없을 때의 반환값").isEqualTo(false);
    }

    @DisplayName("빈칸이 있는지 확인한다.")
    @Test
    void validEmpty() {
        assertThat(Validation.validBlank("1,2,3,4,5,6")).as("정상적인 값일 때의 반환값").isEqualTo(true);
        assertThat(Validation.validBlank("1,,3,4,5,6")).as("빈칸이 있을 때의 반환값").isEqualTo(false);
    }

    @DisplayName("6개 번호가 모두 있는지 확인한다.")
    @Test
    void validSize() {
        assertThat(Validation.validSize("1", 1)).as("번호가 일치할 때의 반환값").isEqualTo(false);
        assertThat(Validation.validSize("1,2,3,4,5,6", 6)).as("번호가 일치할 때의 반환값").isEqualTo(true);
        assertThat(Validation.validSize("1,2,3,4,5,6,7", 6)).as("번호가 많을 때의 반환값").isEqualTo(false);
        assertThat(Validation.validSize("1,2,3,4,5", 6)).as("번호가 적을 때의 반환값").isEqualTo(false);
    }
}