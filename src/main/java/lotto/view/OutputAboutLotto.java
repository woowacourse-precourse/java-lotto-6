package lotto.view;

import lotto.constant.Phrases;
import lotto.domain.db.PurchaseLotto;

import java.util.List;

public class OutputAboutLotto {
    public static void printInputLottoNumber() {
        System.out.println();
        System.out.println(Phrases.lottoInputPhrase);
    }

    public static void printPurchaseLottoNumbers(List<Integer> lottos) {
        System.out.println(lottos.toString());
    }

    public static void printInputBonusNumber() {
        System.out.println();
        System.out.println(Phrases.bonusInputPhrase);
    }
}
