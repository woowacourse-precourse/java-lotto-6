package lotto.service;

import lotto.model.PublishedLotto;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class PublishLottoService implements Service {
    private final LottoOutputView lottoOutputView;

    PublishLottoService(View lottoOutputView) {
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
    }

    public PublishedLotto getPublishedLotto(Integer money) {
        PublishedLotto publishedLotto = PublishedLotto.getInstance(money);
        lottoOutputView.printPublishedLotto(publishedLotto.getCount(), publishedLotto.toString());
        return publishedLotto;
    }
}
