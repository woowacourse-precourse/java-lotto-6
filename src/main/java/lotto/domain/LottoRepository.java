package lotto.domain;

public class LottoRepository {

    private Lottos lottos;

    public void saveAll(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos findAll() { return lottos;}


}
