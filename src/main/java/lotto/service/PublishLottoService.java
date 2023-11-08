package lotto.service;

import lotto.model.PublishedLotto;
import lotto.view.LottoOutputView;

public class PublishLottoService implements Service {
    PublishLottoService() {
    }

    /**
     * 구입 금액에 맞게 로또를 발행하고, 발행된 로또를 메시지로 출력하는 메서드.
     *
     * @param money 구입 금액(Integer)
     * @param outputView 출력 담당 객체(LottoOutputView)
     * @return 발행된 로또(PublishedLotto)
     */
    public PublishedLotto getPublishedLotto(final Integer money, final LottoOutputView outputView) {
        PublishedLotto publishedLotto = PublishedLotto.getInstance(money);
        outputView.printPublishedLotto(publishedLotto.getCount(), publishedLotto.toString());
        return publishedLotto;
    }
}
