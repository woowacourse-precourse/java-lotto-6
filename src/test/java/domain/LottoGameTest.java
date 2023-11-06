package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void init(){
        lottoGame = new LottoGame();
    }

    @DisplayName("로또 당첨번호는 1~45 사이 이다.")
    @Test
    void createLottoNumbersTest() {
        // given
        List<Integer> lottoNumbers = lottoGame.createLottoNumbers();

        // when
        boolean isNumber1To45 = lottoNumbers.stream()
                .allMatch(num -> num >= 1 && num <= 45);

        //then
        assertThat(isNumber1To45).isTrue();
        System.out.println(lottoNumbers);
    }


}
