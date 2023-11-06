package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class LottoModel {
    private int lottoPrice;
    private List<Lotto> boughtLottos;

    public LottoModel() {
        lottoPrice = LottoControl.inputLottoPrice();
        boughtLottos =  generateLottos(lottoPrice);

        LottoView.printLottoAmount(lottoPrice);
        LottoView.printGeneratedLottos(boughtLottos);
    }

    private List<Lotto> generateLottos(int lottoPrice) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for(int i = 0; i < lottoPrice / 1000; i++) {
            Lotto generatedLottoNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            generatedLottos.add(generatedLottoNumber);
        }

        return generatedLottos;
    }
}
