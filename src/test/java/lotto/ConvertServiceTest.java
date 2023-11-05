package lotto;

import lotto.service.convert.ConvertService;
import org.junit.jupiter.api.Test;

public class ConvertServiceTest {
    private ConvertService cs = new ConvertService();

    @Test
    public void stringToNumber(){
        int num = cs.convertStringToNumbers("1000");
        System.out.println(num);
    }
    @Test
    public void stringToNumberException(){
        int num = cs.convertStringToNumbers("1000j");
        System.out.println("예외 터지는 곳 -> -1받아서 예외 터트리기");
        System.out.println(num);
    }

}
