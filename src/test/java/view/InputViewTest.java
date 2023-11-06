package view;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @Nested
    class 입력_공통_예외_처리 {

        @Nested
        class 입력_실패_케이스 {

            @Test
            void 입력이_숫자가_아닐경우_예외_발생() {
                assertThatThrownBy(() -> {
                    int number = Integer.parseInt(",");
                }).isInstanceOf(NumberFormatException.class);
            }
        }

        @Nested
        class 입력_성공_케이스 {

            @Test
            void 입력이_숫자일_경우_성공한다() {
                int number = Integer.parseInt("1");
                assertThat(number).isEqualTo(1);
            }
        }
    }

    @Nested
    class 로또_구입_금액_입력 {

        @Nested
        class 입력_실패_케이스 {

            @Test
            void 입력한_금액이_1000원_이하인_경우_예외_발생() {
                String input = "990";
                assertThatThrownBy(() -> {
                    int amount = Integer.parseInt(input);
                    if (amount <= 1000) {
                        throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위 이상으로 입력해 주세요.");
                    }
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("ERROR] 금액은 1,000원 단위 이상으로 입력해 주세요.");
            }

            @Test
            void 입력한_금액이_1000원으로_나누어_떨어지지_않았을_경우_예외_발생() {
                String input = "1100";
                int division = 1000;
                assertThatThrownBy(() -> {
                    int amount = Integer.parseInt(input);
                    if (amount % division != 0) {
                        throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 입니다.");
                    }
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위 입니다.");
            }
        }

        @Nested
        class 입력_성공_케이스 {

            @Test
            void 입력한_금액이_1000원으로_나누어_떨어지며_성공_한다() {
                String input = "50000";
                int amount = Integer.parseInt(input);
                int division = 1000;
                assertThat(amount % division == 0).isTrue();
            }
        }
    }

    @Nested
    class 당첨_번호_입력 {

        List<Integer> lottoNumbersInput = new ArrayList<>(List.of(1, 2, 3, 4, 5, 55));

        @Nested
        class 입력_실패_케이스 {


            @Test
            void 입력_된_숫자가_45_이상_이상일_경우_예외_발생() {
                assertThatThrownBy(() -> {
                    for (int i = 0; i < lottoNumbersInput.size(); i++) {
                        if (lottoNumbersInput.get(i) > 45) {
                            throw new IllegalArgumentException("[ERROR] 1~45 이하 숫자를 입력해 주세요.");
                        }
                    }
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 1~45 이하 숫자를 입력해 주세요.");
            }

            @Test
            void 입력_된_숫자가_7개_이상일_경우_예외_발생() {
                lottoNumbersInput.add(44);
                assertThatThrownBy(() -> {
                    if (lottoNumbersInput.size() > 6) {
                        throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 이하로 입력해 주세요.");
                    }
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 당첨 번호는 6개 이하로 입력해 주세요.");
            }

            @ParameterizedTest
            @ValueSource(ints = {1})
            void 당첨_번호_중복_체크(int number) {
                assertThrows(IllegalArgumentException.class, () -> {
                    if (isContains(number)) {
                        throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함 되어 있습니다.");
                    }
                }, "[ERROR] 중복된 숫자가 포함 되어 있습니다.");
            }

            private boolean isContains(int number) {
                return lottoNumbersInput.contains(number);
            }
        }

        @Nested
        class 입력_성공_케이스 {

            @Test
            void 당첨_번호를_입력받을때_쉽표_기준으로_구분에_성공한다() {
                String input = "1,2,3,4,5,6";
                String[] expected = new String[]{"1", "2", "3", "4", "5", "6"};
                String[] actual = input.split(",");
                assertThat(actual).isEqualTo(expected);
                assertThat(actual[0]).isNotIn(",");
            }
        }
    }

    @Nested
    class 보너스_번호_입력 {

        @Nested
        class 입력_실패_케이스 {

            String input = "3,4";

            @Test
            void 보너스_번호가_2개_이상일_경우() {
                assertThatThrownBy(() -> {
                    String[] inputSplitComa = input.split(",");
                    if (inputSplitComa.length > 1) {
                        throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개로 입니다.");
                    }
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR] 보너스 번호는 1개로 입니다.");
            }
        }
    }
}
