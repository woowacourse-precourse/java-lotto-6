package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        String str = Console.readLine();
        int purchaseAmount = UserInputProcessor.purchaseAmountValidator(str);

        List<Lotto> lottoList = Store.publishLotto(purchaseAmount);

        for(Lotto lotto : lottoList) {
            lotto.showLottoNumbers();
        }

    }
}
