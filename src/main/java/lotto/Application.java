package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
//        int money = buyer.getLottoPurchaseAmount();
        List<Integer> lottoNumbers = buyer.getLottoNumber();
        int bonusNumber = buyer.getBonusNumber(lottoNumbers);
        System.out.println(lottoNumbers);
        System.out.println(bonusNumber);

    }
}
