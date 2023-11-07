package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultMakerTest {
    private static final int WRONG = 100;
    private static final int WRONG2 = 200;
    private static final int WRONG3 = 300;
    private ResultMaker resultMaker;
    private Map<Rank, Integer> result;

    @BeforeEach
    void setup() {
        List<Lotto> testLottos = List.of(
                new Lotto(List.of(1, 2, 3, WRONG, WRONG2, WRONG3)),//5등
                new Lotto(List.of(1, 2, 3, WRONG, WRONG2, WRONG3)),//5등
                new Lotto(List.of(1, 2, 3, 4, WRONG, WRONG2)),//4등
                new Lotto(List.of(1, 2, 3, 4, 5, WRONG)),//3등
                new Lotto(List.of(1, 2, 3, 4, 5, WRONG)),//3등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),//2등
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));//1등
        LottoBundle lottoBundle = new LottoBundle(testLottos); //테스트용 로또 뭉치 생성

        SelectedNumbers selectedNumbers = new SelectedNumbers("1,2,3,4,5,6");
        SelectedBonus selectedBonus = new SelectedBonus("7", selectedNumbers);
        SelectedLotto selectedLotto = new SelectedLotto(selectedNumbers, selectedBonus);//테스트용 당첨 번호 생성

        resultMaker = new ResultMaker(lottoBundle, selectedLotto);

    }

    @DisplayName("생성된 로또와 당첨된 로또 사이의 결과를 비교가 잘 되었음을 확인")
    @Test
    void checkCorrectResult() {
        resultMaker.updateResult();
        result = resultMaker.giveResult();

        assertThat(result.get(Rank.FIFTH_PLACE)).isEqualTo(2);
        assertThat(result.get(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD_PLACE)).isEqualTo(2);
        assertThat(result.get(Rank.SECOND_PLACE)).isEqualTo(1);
        assertThat(result.get(Rank.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("결과를 바탕으로 수익률을 잘 계산하는지 확인")
    @Test
    void checkCorrectRateOfReturn() {
        resultMaker.updateResult();
        String rateOfReturn = resultMaker.calculateRateOfReturn();

        assertThat(rateOfReturn).isEqualTo("29,043,714.3");
    }
}