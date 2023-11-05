package mytest;

import static model.LottoGenerator.generateLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import model.LottoGenerator;
import model.Numbergeneratable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions. *;

public class LottoGeneratorTest {
    @Test
    @DisplayName("컴퓨터의 로또를 잘 생성하는지 테스트")
    void generateLottoTestForComputer()
    {
        Integer[] testArray = {1,2,3,4,5,6};
        List<Lotto> testLotto = LottoGenerator.generateLotto(1,
                () -> new ArrayList<>(Arrays.asList(testArray)));
        for(Lotto temp : testLotto)
        {
            List<Integer> lotto = temp.getNumbers();
            for(int i = 0; i < lotto.size(); i++)
            {
                assertThat(lotto.get(i)).isEqualTo(testArray[i]);
            }
        }
        }

    @Test
    @DisplayName("유저의 로또를 잘 생성하는지 테스트")
    void generateLottoTestForUser()
    {
        Integer[] testArray = {10,13,16,20,34,45};
        Lotto testLotto = LottoGenerator.generateLotto(testArray);
        List<Integer> testList = testLotto.getNumbers();
        for(int i = 0; i < testList.size(); i++)
        {
            assertThat(testList.get(i)).isEqualTo(testArray[i]);
        }
    }
}
