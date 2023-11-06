package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumRandomGeneratorTest {

    @Test
    public void 오름차순정렬테스트(){
        LottoNumRandomGenerator lottoNumRandomGenerator = new LottoNumRandomGenerator();

        List<Integer> numbers = lottoNumRandomGenerator.setRandomNum();

        for(int data:numbers){
            System.out.print(data+" ");
        }
    }
}
