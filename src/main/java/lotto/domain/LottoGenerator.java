package lotto.domain;


public sealed interface LottoGenerator permits RandomLottoGenerator, ManualLottoGenerator {
    Lottos generate(int availablePurchase);
}
