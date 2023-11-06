package lotto;
import camp.nextstep.edu.missionutils.Randoms; import java.util.ArrayList; import java.util.Collections;

public class LottoModel {
    private int lottoPrice;
    private ArrayList<Lotto> boughtLottos;

    public LottoModel() {
        lottoPrice = LottoControl.inputLottoPrice();
        boughtLottos =  generateLottos(lottoPrice);

        LottoView.printLottoAmount(lottoPrice);
        LottoView.printGeneratedLottos(boughtLottos);
    }

    private ArrayList<Lotto> generateLottos(int lottoPrice) {
        ArrayList<Lotto> generatedLottos = new ArrayList<>();

        for(int i = 0; i < lottoPrice / 1000; i++) {
            Lotto generatedLottoNumber = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(generatedLottoNumber.getNumbers());
            generatedLottos.add(generatedLottoNumber);
        }

        return generatedLottos;
    }
}
