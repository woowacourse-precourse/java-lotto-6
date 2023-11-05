package lotto.DomainTest;

import java.util.List;
import lotto.Domain.LottoSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSystemTest {
    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,6','1,3,5,6,9,20','2,3,6,7,8,20'"})
    void compareLottoNumbersTest(List<String> purchasedNumbers){
        LottoSystem lottoSystem = new LottoSystem("1,2,3,4,5,6", "7");;
//        List<Integer> result = lottoSystem.compareLottoNumbers(purchasedNumbers);
//        for(int re : result){
//            System.out.println(re);
//        }
    }
//    @Test
//    void lottoSystemConstructorTest(){
//        LottoSystem lottoSystem = new LottoSystem("1 ,2,  3,  4,5  ,6", "7");
//        lottoSystem.print();
//    }
}
