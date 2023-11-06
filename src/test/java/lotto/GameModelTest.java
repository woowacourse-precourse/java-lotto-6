package lotto;

import java.util.ArrayList;
import lotto.Model.GameModel;
import lotto.Model.VO.LottoData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameModelTest {

    @ParameterizedTest
    @CsvSource({
            "1000, 1",
            "5000, 5",
            "99000, 99",
            "990000, 990"
    })
    public void 로또가_금액에대한_갯수만큼_저장되는지_확인(Integer cache,Integer count) {
        GameModel gameModel= new GameModel();
        gameModel.initGameModel(cache);
        gameModel.lottoIssuance();

        ArrayList<LottoData> testLottoDatas = gameModel.transferPlayerLottoDatas();

        // 테스트 라이브러리를 이용해 조절가능한 랜덤값 6자리의 로또를 생성하고
        // 생성된 로또데이터를 Arraylist<LottoData>에 잘 저장하는지 확인하는 코드를 작성하라

        // 여기부터 코드작성
        Assertions.assertThat(testLottoDatas.size()).isEqualTo(count);

    }

}
