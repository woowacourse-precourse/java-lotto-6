package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 당첨번호_숫자_범위는_1부터_45까지() {
        assertThatThrownBy(() ->{
            List<Integer> result = new ArrayList<>();
            System.out.println("당첨 번호를 입력해주세요");
            String winningNumbers = "1,24,7,46,22,1";
            String[] deletedCommaWinningNumbers = winningNumbers.split(",");

            for (String deletedCommaWinningNumber : deletedCommaWinningNumbers) {
                int winningNumber = Integer.parseInt(deletedCommaWinningNumber);
                if (winningNumber < 1 || winningNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                result.add(winningNumber);
            }
        })
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

}