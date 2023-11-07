package lotto.domain;

public class LottoRepository {

    private Lottos lottos;

    public Lottos makeLottos(int lottoCount) {
        lottos = new Lottos();

        LottoMachine lottoMachine = new LottoMachine();
        for (int count = 0; count < lottoCount; count++) {
            lottos.add(lottoMachine.makeLotto());
        }
        return lottos;
    }
}
