package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;

public class LottoGeneratorTrueTest {

    @Test
    public void TestTrue(){
        //가짜 랜덤이 아닌지 테스트
        List<Integer> list1 = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> list2
          = Randoms.pickUniqueNumbersInRange(1,45,7);
        System.out.println(list1);
        System.out.println(list2);
        TreeSet<Integer> listset = new TreeSet<>();
        listset.add(list1.get(1));
    }

}
