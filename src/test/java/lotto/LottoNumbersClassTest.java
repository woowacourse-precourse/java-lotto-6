package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.vo.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

@DisplayName("LottoNumbers 클래스 테스트")
public class LottoNumbersClassTest {

    private LottoNumbers lottoNumbers;
    @BeforeEach
    public void setup(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        TreeSet<Integer> sortNumbers = new TreeSet<>(randomNumbers);
        List
        lottoNumbers = new LottoNumbers(sortNumbers);
    }
    @Test
    public void NumberTest(){
    }



}
