package lotto;

import lotto.service.convert.ConvertService;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConvertServiceTest {
    private ConvertService cs = new ConvertService();
    @Test
    @IgnoreForBinding
    public void 정상출력(){
        int num = cs.ConvertStringToNumber("1000");
        System.out.println(num);
    }
    @Test
    @IgnoreForBinding
    public void 파싱실패예외(){
        int num = cs.ConvertStringToNumber("1000j");
        System.out.println("파싱 예외 -> -1받아서 예외 터트리기");
        System.out.println(num);
    }
    @Test
    @IgnoreForBinding
    public void 나머지0이아닐때예외(){
        int num = cs.ConvertStringToNumber("1001");
        System.out.println("나머지 예외 -> 0받아서 예외 터트리기");
        System.out.println(0);
    }
    @Test
    public void 로또번호input변환테스트(){
        List<Integer> nums = cs.ConvertStringToNumbers("1,2,3,4,5,6",6);
        System.out.println(nums);
    }
    @Test
    public void 로또번호input숫자이외의input테스트(){
        List<Integer> nums = cs.ConvertStringToNumbers("1,3,4,6,7,8,9",7);
        System.out.println(nums);
    }


}
