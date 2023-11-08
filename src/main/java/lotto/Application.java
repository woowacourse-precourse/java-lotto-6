package lotto;

import java.text.DecimalFormat;

public class Application {
    public static void main(String[] args) {
        LottoMachine tryIt = new LottoMachine(new DecimalFormat("#.##"));
        tryIt.run();
    }
}
