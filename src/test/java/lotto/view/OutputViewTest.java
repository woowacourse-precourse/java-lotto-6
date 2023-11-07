package lotto.view;

import lotto.domain.Lotto;
import lotto.model.LottoNumberModel;
import lotto.model.LottoResultModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    public void createOutputView(){
        outputView = new OutputView();
    }

    @Test
    @DisplayName("구매한 로또 개수와 번호를 표시합니다.")
    void purchaseLottoNumbersDisplay() {
        Lotto lotto= new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        LottoNumberModel lottoNumberModel = new LottoNumberModel(lottos);
        outputView.purchaseLottoNumbersDisplay(lottoNumberModel);
    }

    @Test
    @DisplayName("로또 당첨 결괴를 표시합니다.")
    void lottoResultDisplay() {
        LottoResultModel lottoResultModel = new LottoResultModel("62.5","1","2","3","4","5");
        outputView.lottoResultDisplay(lottoResultModel);
    }
}