package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.Lotto;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class LottoService {
    private final InputView inputView;

    public LottoService() {
        inputView = new InputView();
    }

    public void buyLotto(){
        int money = inputView.enterPriceToBuy();
        int lottoCnt = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = new ArrayList<>();
            while (lottoNumbers.size() < 6){
                int lottoNumber = Randoms.pickNumberInRange(1, 45);
                if (lottoNumbers.contains(lottoNumber)){
                    continue;
                }
                lottoNumbers.add(lottoNumber);
            }
            lottos.add(new Lotto(lottoNumbers));
        }
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            lotto.showLottoNumbers();
        }
    }
}
