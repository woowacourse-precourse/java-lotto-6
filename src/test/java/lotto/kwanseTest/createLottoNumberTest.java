package lotto.kwanseTest;

import static java.awt.AWTEventMulticaster.add;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.WinningPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class createLottoNumberTest {

    private List<List>allLottoNumbers = new ArrayList<>();

    @Test
    void 랜덤값이_리스트에_제대로_넣어지는지 () {
        for (int i=0; i<2; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            allLottoNumbers.add(numbers);
        }
        System.out.println("allLottoNumbers = " + allLottoNumbers);
    }

    @Test //Enum 검증
    void findByCount_Test () {
        WinningPrize winningPrize = WinningPrize.findByCount(6);
        Assertions.assertThat(winningPrize.getDescription()).isEqualTo("6개 일치");
        Assertions.assertThat(winningPrize.name()).contains("FIRST_PLACE");

        Assertions.assertThat(winningPrize.getCountAndPrize().get(0)).isEqualTo(6);
    }

    @Test //winningCount 가 5일 경우 뭐가 입력될것인가
    void findByCount_Test2 () {
        //먼저 있는 값이 입력됨.
        WinningPrize winningPrize = WinningPrize.findByCount(5);
        System.out.println("winningPrize = " + winningPrize.getCountAndPrize().get(2));

        Assertions.assertThat(1).isEqualTo(1);
    }

    //오름차순 검증

    //반올림 검증

    //Calculator 각각 검증

    //예외 검증


}
