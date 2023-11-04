package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottosDto {

    List<String> purchasedLottos;

    private PurchasedLottosDto(List<String> lottos) {
        purchasedLottos = new ArrayList<>(lottos);
    }

    public static PurchasedLottosDto from(List<String> lottos) {
        return new PurchasedLottosDto(lottos);
    }

    public List<String> show() {
        return purchasedLottos;
    }

}
