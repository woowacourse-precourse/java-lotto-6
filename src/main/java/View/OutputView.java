package View;

import java.util.List;

public class OutputView {
    TextView textView = new TextView();
    public void lottoNumber(List<Integer> lottoNum) {
        System.out.print("[");
        for (int i = 0; i+1 < lottoNum.size(); i++) {
            System.out.printf("%d, ", lottoNum.get(i));
        }
        System.out.printf("%d]\n", lottoNum.get(5));
    }

    public void numberOfWins(List<Integer> wins) {
        textView.prize();
        for (int i = 0; i < wins.size(); i++) {
            System.out.printf("%s%d개\n", textView.prizeDetails().get(i), wins.get(i));
        }
    }

    public void yield(float price) {
        System.out.printf("총 수익률은 %.2f%%입니다.", price);
    }
}
