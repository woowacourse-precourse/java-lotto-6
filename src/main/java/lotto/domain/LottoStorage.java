package lotto.domain;


public class LottoStorage {

    private final WinningLotto winningLotto;
    private final Integer totalPrice;

    public LottoStorage(WinningLotto winningLotto, Integer totalPrice) {
        this.winningLotto = winningLotto;
        this.totalPrice = totalPrice;
    }


}
