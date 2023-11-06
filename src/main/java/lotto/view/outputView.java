package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class outputView {
    //발행된 로또 번호 출력
    public static void IssuedLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    //당첨 내역 출력


    //총 수익률 출력
}
