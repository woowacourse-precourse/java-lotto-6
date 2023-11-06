package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호를 생성한다.")
    void createBonusNumberException() {
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        String bonusNum = "7";
        BonusNumber bonusNumber = lotto.model.BonusNumber.createBonusNumber(winningNumber,bonusNum);
        assertEquals(bonusNumber.getBonusNumber(),7);
    }
}