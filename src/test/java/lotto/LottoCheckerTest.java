package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class LottoCheckerTest {
    @Test
    public void 입력한_정답번호가_숫자가_아닐_시_예외가_발생한다() {
        String input = "1,ㅇ,3";
        String bonus = "10";

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new LottoChecker(input, bonus);
        });
        assertThat(e.getMessage()).isEqualTo("[ERROR] 로또의 번호는 숫자로만 입력해야 합니다.");
    }

    @Test
    public void 입력한_정답번호가_6개가_아닐_시_예외가_발생한다() {
        String input = "1,2,3,4,5";
        String bonus = "10";

        Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
            new LottoChecker(input, bonus);
        });
        assertThat(e1.getMessage()).isEqualTo("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    public void 입력한_정답번호중_중복된_숫자가_있을_시_예외가_발생한다() {
        String input = "1,2,3,4,5,1";
        String bonus = "10";


        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new LottoChecker(input, bonus);
        });

        assertThat(e.getMessage()).isEqualTo("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
    }

    @Test
    public void 입력한_보너스번호가_당첨번호와_중복시_예외가_발생한다() {
        String input = "1,2,3,4,5,6";
        String bonus = "6";

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new LottoChecker(input, bonus);
        });
        assertThat(e.getMessage()).isEqualTo("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    public void 입력한_숫자가_로또범위를_넘어갈_시_예외가_발생한다() {
        String input = "1,2,3,4,5,61";
        String bonus = "10";

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new LottoChecker(input, bonus);
        });
        assertThat(e.getMessage()).isEqualTo("[ERROR] 각각의 당첨 번호는 1~45 사이여야 합니다.");
    }

    @Test
    public void 로또들을_인자로_check호출시_올바른_등수를_반환한다() {
        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto none = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        String answer = "1,2,3,4,5,6";
        String bonus = "7";

        LottoChecker lottoChecker = new LottoChecker(answer, bonus);
        List<LottoPrize> lottoPrizes = lottoChecker.check(List.of(first, second,  third, fourth, fifth, none));

        assertThat(lottoPrizes).containsExactly(LottoPrize.FIRST, LottoPrize.SECOND, LottoPrize.THIRD, LottoPrize.FOURTH, LottoPrize.FIFTH, LottoPrize.NONE);
    }
}
