package lotto.view;

import lotto.model.Lotto;
import lotto.model.User;

import java.util.List;

public class OutputView {

    private static final int LOTTO_PRICE = 1000;

    public static void displaylottosList(User user){
        int amount = user.getUserAmount();
        List<Lotto> lottos = user.getUserLottos();
        displayPurchase(amount);
        for(Lotto lotto : lottos){
            displayLotto(lotto);
        }
    }

    public static void displayPurchase(int amount){
        int purchaseNumber = amount/LOTTO_PRICE;
        System.out.println(purchaseNumber+"개를 구매했습니다.");
    }

    public static void displayLotto(Lotto lotto){
        List<Integer> lottoNumbers = lotto.getNumbers();
        System.out.println(lottoNumbers);
    }
}
