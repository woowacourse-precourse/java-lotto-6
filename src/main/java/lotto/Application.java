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
        for (List<Integer> lottoNumber : buyer.generateLottoNumbers()) {
            System.out.println(lottoNumber);
        }
    }
}
