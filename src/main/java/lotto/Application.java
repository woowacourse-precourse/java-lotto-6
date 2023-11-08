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

        System.out.println("당첨 번호를 입력해주세요.");
        String lottoNumbers = Console.readLine();

        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();

        String[] arr = lottoNumbers.split(",");
        LottoManager lotto = new LottoManager(arr, bonusNumber);

        lotto.checkWining(lottoList);

        lotto.showWiningStatics();
    }
}
