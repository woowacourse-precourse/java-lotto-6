package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;

public class OutputView {

    public void printLotto(User user){
        System.out.println((user.getPayed() / 1000) + "개를 구매했습니다.");
        for (Lotto lotto : user.getLottos()){
            System.out.println(lotto.toString());
        }
    }

}
