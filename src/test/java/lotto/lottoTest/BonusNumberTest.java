package lotto.lottoTest;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.service.LottoService.enterBonusNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {

    public void init(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 43), "보너스_번호_테스트", 45)
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("보너스_번호를_입력받는_테스트")
    public void lottoBonusNumberTest(List<Integer> numbers){
        //given
        String input = "7";
        init(input);

        //when
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = enterBonusNumber(lotto);

        //then
        assertThat(bonusNumber).isEqualTo(Integer.parseInt(input));
    }
}
