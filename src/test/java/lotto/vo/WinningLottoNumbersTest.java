package lotto.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumbersTest {
    @DisplayName("올바르게 생성되었는지 확인")
    @Test
    void createRightMoney(){
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers);
        Assertions.assertEquals(winningLottoNumbers.value(),winningNumbers);
    }
}
