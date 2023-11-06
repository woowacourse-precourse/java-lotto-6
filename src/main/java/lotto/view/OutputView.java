package lotto.view;

import java.util.List;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        StringBuilder sb = new StringBuilder("[");
        lottoNumbers.stream().forEach(n -> sb.append(n + ", "));
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
    }

}
