package lotto;


import lotto.generator.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator =new LottoNumberGenerator();
        Lotto lotto =new Lotto(lottoNumberGenerator.NumberGenerator());


        // TODO: 프로그램 구현
    }
}
