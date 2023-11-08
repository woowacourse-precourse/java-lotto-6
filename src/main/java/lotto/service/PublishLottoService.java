package lotto.service;

import lotto.model.PublishedLotto;
import lotto.view.LottoOutputView;

public class PublishLottoService implements Service {
    PublishLottoService() {
    }

    public PublishedLotto getPublishedLotto(final Integer money, final LottoOutputView outputView) {
        PublishedLotto publishedLotto = PublishedLotto.getInstance(money);
        outputView.printPublishedLotto(publishedLotto.getCount(), publishedLotto.toString());
        return publishedLotto;
    }
}
