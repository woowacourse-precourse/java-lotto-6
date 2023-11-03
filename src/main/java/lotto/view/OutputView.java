package lotto.view;

import java.util.*;

public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printLottoNumbers(List<List<Integer>> lottosNumbers) {
        System.out.printf("\n%s개를 구매했습니다.%n", lottosNumbers.size());
        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
    }
}
