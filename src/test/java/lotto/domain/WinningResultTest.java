package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningResultTest {

    @DisplayName("랜덤 생성된 로또 번호와 당첨번호를 비교하여 해당되는 등수를 얻지 못하면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD",
    "1,2,3,4,9,10:FOURTH", "1,2,3,11,12,13:FIFTH", "1,2,8,9,10,11:MISS"}, delimiter = ':')
    void compare(String input, Rank rank) {
        String[] inputList = input.split(",");
        List<Integer> testNumList = new ArrayList<>();
        for (int i = 0; i < inputList.length; i++) {
            testNumList.add(Integer.parseInt(inputList[i]));
        }
        Lotto testlotto = new Lotto(testNumList);

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningResult winningResult = new WinningResult(lotto, bonusNumber);

        Assertions.assertThat(winningResult.match(testlotto)).isEqualTo(rank);
    }
}
