package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TestLottoFunction {



    @Test
    public void TestMakeLotto(){

        System.out.println("-----------------");
        System.out.println("test result");
        for(int i=0;i<10;i++) {
            List<Integer> testValue = Lotto.makeLotto();
            for (int number : testValue) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------");
    }

    @Test
    public void TestToString(){

        List<Integer> testValue = Lotto.makeLotto();
        Lotto lotto = new Lotto(testValue);
        System.out.println("-----------------");
        System.out.println("test result : " + lotto.toString());
        System.out.println("-----------------");

    }
}
