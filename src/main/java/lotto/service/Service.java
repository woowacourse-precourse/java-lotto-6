package lotto.service;

import lotto.view.View;

public interface Service {
    static Service generateInputService(final View lottoInputView) {
        return new InputService(lottoInputView);
    }

    static Service generatePublishLottoService() {
        return new PublishLottoService();
    }

    static Service generateConfirmWinningService() {
        return new ConfirmWinningService();
    }

    static Service generateCalculateProfitService() {
        return new CalculateProfitService();
    }
}
