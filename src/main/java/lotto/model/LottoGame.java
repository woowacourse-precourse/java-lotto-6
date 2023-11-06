package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.model.User;
import lotto.view.InputView;

public class LottoGame {

    private User InitUser(){
        int amount = InputView.validateInputAmount();
        List<Lotto> lottos = createLottos(amount);
        User user = new User(amount,lottos);
        return user;
    }

    private List<Integer> generateLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return lottoNumbers;
    }

    private List<Lotto> createLottos(int amount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i< calculateAmount(amount); i++){
            Lotto lotto = new Lotto(generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
    private int calculateAmount(int amount){
        return amount/1000;
    }

}
