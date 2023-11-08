package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i< numbers.size();i++) {
            sb.append(numbers.get(i)).append(", ");
        }
        sb.deleteCharAt(sb.length()-2);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        System.out.println(sb);
    }
}
