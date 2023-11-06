package domain;

import camp.nextstep.edu.missionutils.Randoms;
import dto.Lotto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import view.InputView;

public class PublishLottoUtil {

    private final InputView inputView;

    public PublishLottoUtil(){
        inputView = new InputView();
    }

    public Integer buyLotto() {
        int money = inputView.enterPriceToBuy();
        int lottoCnt = money / Constants.LOTTO_PRICE;
        System.out.println(lottoCnt + Constants.BUY_HOW_MANY);
        return lottoCnt;
    }

    private List<Integer> pickLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < Constants.LOTTO_NUMBER_CNT) {
            int lottoNumber = Randoms.pickNumberInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER);
            if (lottoNumbers.contains(lottoNumber)) {
                continue;
            }
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> publishLotto(int lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }

    public void showPublishedLotto(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            lotto.showLottoNumbers();
        }
    }
}
