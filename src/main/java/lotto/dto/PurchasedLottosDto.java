package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottosDto {

    List<List<Integer>> purchasedLottos;

    private PurchasedLottosDto(List<List<Integer>> lottos) {
        purchasedLottos = new ArrayList<>(lottos);
    }

    public static PurchasedLottosDto from(List< List<Integer>> lottos) {
        return new PurchasedLottosDto(lottos);
    }

    public List<List<Integer>>  show() {
        return purchasedLottos;
    }

}
