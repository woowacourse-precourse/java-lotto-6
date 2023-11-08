package lotto.service;

import lotto.model.PublishedLotto;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class PublishLottoService implements Service {

    PublishLottoService() {
    }

    public PublishedLotto getPublishedLotto(Integer money, LottoOutputView lottoOutputView) {
        PublishedLotto publishedLotto = PublishedLotto.getInstance(money);
        lottoOutputView.printPublishedLotto(publishedLotto.getCount(), publishedLotto.toString());
        return publishedLotto;
    }
}
