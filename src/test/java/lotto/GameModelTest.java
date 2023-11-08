package lotto;

import java.util.ArrayList;
import lotto.Controller.ErrorMessage;
import lotto.Model.GameModel;
import lotto.Model.LottoPlayer;
import lotto.Model.VO.LottoData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameModelTest {

    @ParameterizedTest
    @ValueSource(strings= {"asda","asdasd,assa", "13,asd,9"})
    public void 정답로또에_문자를_입력하는_경우_예외처리(String lottos) {
        GameModel gameModel= new GameModel();
        Assertions.assertThatThrownBy(() -> gameModel.initAnswerByStrings(lottos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NOT_NUMBER.getMessage());
    }

}
