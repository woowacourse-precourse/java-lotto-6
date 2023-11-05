package lotto;

import lotto.domain.Generate;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Generate generate = new Generate();
        generate.LottoGenerate(6);
    }
}
