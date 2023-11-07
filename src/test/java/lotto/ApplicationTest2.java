package lotto;
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest2 {
    @Test
    void 금액_입력_예외처리(){

    }
    @Test
    void 정렬_잘되는지_테스트(){
        List<Integer> willSortNum = Application.sortNumber(Arrays.asList(6,5,4,3,2,1));
        assertThat(willSortNum).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
    @Test
    void 토큰분리_잘되는지_테스트(){
        List<Integer> lottoNum = Application.tokenSeparation("1,2,3,4,5,6");
        assertThat(lottoNum).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
    @Test
    void 토큰분리_예외_테스트(){
        boolean lottoException = Application.countNumException(7);
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
        
    }
}