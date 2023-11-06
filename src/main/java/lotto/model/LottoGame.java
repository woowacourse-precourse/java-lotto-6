package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    public User InitUser(){
        int amount = InputView.validateInputAmount();
        List<Lotto> lottos = createLottos(amount);
        User user = new User(amount,lottos);
        OutputView.displaylottosList(user);
        return user;
    }

    private List<Integer> generateLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumbers;
    }

    private List<Lotto> createLottos(int amount){
        List<Lotto> lottos = new ArrayList<>();
        int purchaseNumber = amount/LOTTO_PRICE;
        for(int i = 0; i< purchaseNumber; i++){
            Lotto lotto = new Lotto(generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }

}
