package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 로또_구매갯수_정상출력_테스트() {
        //given
        int payment = 58000;
        int bonusNumber = 8;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        Validation validation = new Validation();
        validation.userInputValue(winningNumbers, bonusNumber);
        int result = validation.lottoPurchaseNumber(payment);
        //then
        assertThat(result).isEqualTo(58);
    }

    @Test
    void 당첨통계_정상출력_테스트() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 8;
        List<List<Integer>> fullLottoValue = new ArrayList<>();
        List<Integer> innerList1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> innerList2 = List.of(1, 9, 3, 25, 5, 56);
        List<Integer> innerList3 = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> innerList4 = List.of(1, 2, 3, 4, 5, 9);
        fullLottoValue.add(innerList1);
        fullLottoValue.add(innerList2);
        fullLottoValue.add(innerList3);
        fullLottoValue.add(innerList4);
        //when
        Validation validation = new Validation();
        validation.userInputValue(winningNumbers, bonusNumber);
        List<Integer> result = validation.winningStatics(fullLottoValue);
        //then
        assertThat(result).isEqualTo(List.of(1, 0, 1, 1, 1));
    }

    @Test
    void 수익률_정상출력_테스트() {
        //given
        int payment = 8000;
        List<Integer> winningStaticsResult = List.of(1, 0, 0, 0, 0);
        //when
        Validation validation = new Validation();
        double result = validation.totalReturnCalculate(winningStaticsResult, payment);
        //then
        assertThat(result).isEqualTo(62.5);
    }
}
