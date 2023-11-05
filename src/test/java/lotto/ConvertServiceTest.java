package lotto;

import lotto.service.convert.ConvertService;
import org.junit.jupiter.api.Test;

public class ConvertServiceTest {
    private ConvertService cs = new ConvertService();
    @Test
    public void 정상출력(){
        int num = cs.moneyConvertStringToNumbers("1000");
        System.out.println(num);
    }
    @Test
    public void 파싱실패예외(){
        int num = cs.moneyConvertStringToNumbers("1000j");
        System.out.println("파싱 예외 -> -1받아서 예외 터트리기");
        System.out.println(num);
    }
    @Test
    public void 나머지0이아닐때예외(){
        int num = cs.moneyConvertStringToNumbers("1001");
        System.out.println("나머지 예외 -> 0받아서 예외 터트리기");
        System.out.println(0);
    }
}
