package lotto.service;

import lotto.view.View;

public interface Service {
    static Service generateInputService(View lottoInputView) {
        return new InputService(lottoInputView);
    }

    static Service generatePublishLottoService(View lottoOutputView) {
        return new PublishLottoService(lottoOutputView);
    }
}
