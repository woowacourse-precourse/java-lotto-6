package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
//        int money = buyer.getLottoPurchaseAmount();
//        int bonusNumber = buyer.getBonusNumber(lottoNumbers);
        List<List<Integer>> lottoNumbers = buyer.generateLottoNumbers();
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }

        List<Integer> winningNumber = buyer.getWinningNumber();
        int bonusNumber = buyer.getBonusNumber();
        System.out.println();
        System.out.println(winningNumber);
        System.out.println();
        System.out.println(bonusNumber);

        for (List<Integer> lottoNumber : lottoNumbers) {
            Lotto lotto = new Lotto(lottoNumber);
            int result = lotto.LottoResults(winningNumber, bonusNumber);
            System.out.println(result);
        }

    }
}
