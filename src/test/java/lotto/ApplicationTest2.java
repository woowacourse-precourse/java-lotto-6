package lotto;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest2 {
    @Test
    void 정렬_잘되는지_테스트(){
        List<Integer> willSortNum = Application.sortNumber(Arrays.asList(6,5,4,3,2,1));
        assertThat(willSortNum).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
    @Test
    void 토큰분리_잘되는지_테스트(){
        List<Integer> lottoNum = Application.tokenSeparation("1,2,3,4,5,6");
        assertThat(lottoNum).isEqualTo(Arrays.asList(1,2,3,4,5,6));
        lottoNum = Application.tokenSeparation("1,2,3,4,5,six");
        assertThat(lottoNum).isEqualTo(null);
        lottoNum = Application.tokenSeparation("1,2,3,4,5");
        assertThat(lottoNum).isEqualTo(null);
    }
    @Test
    void 토큰분리_예외_테스트(){
        boolean lottoException = Application.countNumException(7);
        assertThat(lottoException).isEqualTo(false);
        lottoException = Application.countNumException(6);
        assertThat(lottoException).isEqualTo(true);
        lottoException = Application.countNumException(5);
        assertThat(lottoException).isEqualTo(false);
    }
    @Test
    void 문자열로_받고_정수형으로_바꾸기_테스트(){
        int eachLottoNum = Application.changeToInteger("30");
        assertThat(eachLottoNum).isEqualTo(30);
        eachLottoNum = Application.changeToInteger("eleven");
        assertThat(eachLottoNum).isEqualTo(0);
    }
    @Test
    void 같은숫자_몇개인지_출력_테스트(){
        int howManySameNumber = Application.howManySame(Arrays.asList(6,5,4,3,2,1),Arrays.asList(5,6,7,8,9,10));
        assertThat(howManySameNumber).isEqualTo(2);
        howManySameNumber = Application.howManySame(Arrays.asList(6,5,4,3,2,1),Arrays.asList(5,6,7,8,9,4));
        assertThat(howManySameNumber).isEqualTo(3);
        howManySameNumber = Application.howManySame(Arrays.asList(6,5,4,3,2,1),Arrays.asList(5,6,7,8,3,4));
        assertThat(howManySameNumber).isEqualTo(4);
        howManySameNumber = Application.howManySame(Arrays.asList(6,5,4,3,2,1),Arrays.asList(5,6,7,2,3,4));
        assertThat(howManySameNumber).isEqualTo(5);
        howManySameNumber = Application.howManySame(Arrays.asList(6,5,4,3,2,1),Arrays.asList(1,2,3,4,5,6));
        assertThat(howManySameNumber).isEqualTo(7);
    }
}