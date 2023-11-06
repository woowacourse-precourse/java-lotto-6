package lotto.print;

import lotto.Lotto;

import java.util.List;

public class PrintOutput {
    public void printMoneyQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLottoNumber(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printRandomLottosNumbers(List<Lotto> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int j = 0; j < 5; j++) {
                sb.append(lottos.get(i).getNumbers().get(j)).append(", ");
            }
            sb.append(lottos.get(i).getNumbers().get(5)).append("]");
            System.out.println(sb);
        }
    }
    public void printLottoNumberQuestion(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
