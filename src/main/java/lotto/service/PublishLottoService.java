package lotto.service;

import lotto.model.PublishedLottos;
import lotto.view.LottoOutputView;
import lotto.view.View;

public class PublishLottoService implements Service {
    private final LottoOutputView lottoOutputView;

    PublishLottoService(View lottoOutputView) {
        this.lottoOutputView = (LottoOutputView) lottoOutputView;
    }

    public PublishedLottos getPublishedLottos(Integer money) {
        PublishedLottos publishedLottos = PublishedLottos.getInstance(money);
        lottoOutputView.printPublishedLottos(publishedLottos.getCount(), publishedLottos.toString());
        return publishedLottos;
    }
}
