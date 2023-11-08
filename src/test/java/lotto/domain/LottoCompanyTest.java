package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.ConstantNum.*;

class LottoCompanyTest {
    private List<Integer> numbers;
    private WinningNumbers winningNumbers;
    private BonusNumbers bonusNumbers;


    @BeforeEach
    void setUp() {
        // given
        numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + LOTTO_BONUS_NUMBER_CNT.getNum(); i++) {
            numbers.add(i);
        }
        bonusNumbers = new BonusNumbers(numbers);

        numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN.getNum(); i < LOTTO_NUMBER_MIN.getNum() + WINNING_NUMBER_CNT.getNum(); i++) {
            numbers.add(i);
        }
        winningNumbers = new WinningNumbers(numbers);
    }

    @Test
    @DisplayName("주어진 조건을 충족하는 당첨 번호와 보너스 번호 입력 시, 두 번호를 필드로 가지는 LottoCompany 객체 리턴")
    void testCreateLottoCompany() {
        // when & then
        Assertions.assertThatCode(() -> LottoCompany.createLottoCompany(winningNumbers, bonusNumbers)).doesNotThrowAnyException();
    }
}