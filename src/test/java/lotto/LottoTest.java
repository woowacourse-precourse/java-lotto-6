package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.Lotto.winningNumber;
import static lotto.Lotto.winningNumberLogic;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 당첨번호_숫자_범위는_1부터_45까지() {
        List<Integer> result = new ArrayList<>();
        String[] winningNumbers = {"1","2","3","6","45","48"};
        assertThatThrownBy(() -> winningNumberLogic(result,winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_숫자_범위는_1부터_45까지() {
        assertThatThrownBy(()->{
            System.out.println("보너스 번호를 입력해주세요");
            int bonusNumber = 46;
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨번호와_보너스번호가_같으면_예외처리() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 21, 32, 43, 25, 16));
            int bonusNumber = 16;
            lotto.validationDuplicateWinningNumbersAndBonusNumber(bonusNumber);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨번호와 보너스번호가 중복됩니다.");
    }

    @Test
    void 문자열을_숫자로_바꾸기() {
        String[] str = {"123","123[","123s"};

        assertThatThrownBy(()->{
            for(String s : str){
                Lotto.StringToInt(s);
            }
        })
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR] 숫자 형식이 아닙니다.");

    }


}