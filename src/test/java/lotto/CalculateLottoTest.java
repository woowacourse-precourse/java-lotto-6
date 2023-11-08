package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.domain.CalculateLotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateLottoTest {
        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,10:FOURTH",
                "1,2,3,8,9,10:FIFTH", "1,2,8,9,10,11:NONE"}, delimiter = ':')
        @DisplayName("사용자가 구매한 로또 번호와 당첨번호를 비교해 등수 확인")
        void compare(String input, WinLotto winLotto) {
                String[] list = input.split(",");
                List<Integer> ticketNumberList = new ArrayList<>();
                for (String s : list) {
                        ticketNumberList.add(Integer.parseInt(s));
                }
                Lotto lottos = new Lotto(ticketNumberList);
                Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
                int bonusNumber = 7;
                CalculateLotto calculateLotto = new CalculateLotto(lotto,bonusNumber);

                assertThat(calculateLotto.match(lottos)).isEqualTo(winLotto);
        }

}

