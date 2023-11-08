package lotto.service;

import lotto.view.View;

public interface Service {
    static Service generateInputService() {
        return new InputService();
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
