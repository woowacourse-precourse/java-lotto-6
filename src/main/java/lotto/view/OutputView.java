package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void requestMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAmountLotto(int amount){
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLottoList(List<Lotto> lottoNumbersList){
        for(Lotto lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
