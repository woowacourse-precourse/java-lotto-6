package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.view.ValidationView;
import org.junit.jupiter.api.Test;

public class InputValidationTest {
    @Test
    void 구매_금액_입력_테스트(){
        assertThrows(IllegalArgumentException.class, () -> {
            ValidationView.isDivided("1500");
        });
    }
    @Test
    void 입력_콤마_테스트(){
        String[] arr = new String[]{"1", "", "3"};
        assertThrows(IllegalArgumentException.class, () -> ValidationView.checkConsecutiveCommas(arr));
    }
    @Test
    void 당첨_번호_개수_테스트(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> ValidationView.checkNumberSize(numbers));
    }
    @Test
    void 로또_번호_범위_테스트(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 50);
        assertThrows(IllegalArgumentException.class, () -> ValidationView.checkInRange(numbers));
    }
    @Test
    void 로또_번호_중복_테스트(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        assertThrows(IllegalArgumentException.class, () -> ValidationView.checkDuplicateNumbers(numbers));
    }
}
