package lotto.domain;

// TODO: 로또 생성 전략을 Interface로
public class PurchaseComputer {
    private static PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();

    // TODO: 1000원 단위가 아닌경우, INPUTVIEW에서 예외처리

    public int getCountOfPurchasable(int amount) {
        return amount / 1000;
    }

    public void purchaseLottoForCount(int count) {
        for (int i = 0; i < count; i++) {
            purchaseEachLotto();
        }
    }

    private void purchaseEachLotto() {
        StandardLottoGenerator generator = new StandardLottoGenerator();
        Lotto lottoTicket = new Lotto(generator.generateLottoNumbers());
        purchaseRepository.recordPurchase(lottoTicket);
    }
}
