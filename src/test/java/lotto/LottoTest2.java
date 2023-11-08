package lotto;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest2 {
    @Test
    void 클래스에_저장된_숫자_출력_잘되는지_테스트(){
        List<Integer> lottoNum = new ArrayList<>();
        // 1부터 6까지의 값을 리스트에 추가
        for (int i = 1; i <= 6; i++) {
            lottoNum.add(i);
        }
        Lotto lotto = new Lotto(lottoNum);
        lottoNum = lotto.returnNumbers();
        assertThat(lottoNum).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

}