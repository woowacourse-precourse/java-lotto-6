package lotto;

import java.text.DecimalFormat;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new DecimalFormat("#.##"));
        lottoMachine.run();
    }
}
