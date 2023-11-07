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

    @DisplayName("구매한 로또 당첨 번호 리스트는 null 이 아니다.")
    @Test
    void notNullLottoListTest() {
        // given
        int lottoCount = 15000;

        // when
        List<Lotto> lottoList = getLottoList(lottoCount);

        //then
        assertThat(lottoList).isNotNull();
    }

    @DisplayName("10개의 로또 구매를 구매할 경우 size 는 10이다.")
    @Test
    void purchasedLottoCountTest() {
        // given
        int lottoCount = 10;

        // when
        List<Lotto> lottoList = getLottoList(lottoCount);

        //then
        assertThat(lottoList.size()).isEqualTo(10);
    }

    private List<Lotto> getLottoList(int lottoCount){
        return lottoGame.getLottoList(lottoCount);
    }

}
