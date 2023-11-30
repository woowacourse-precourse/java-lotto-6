package service;

import domain.*;
import dto.LottoDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottosService {
    public Lottos createLottos(final PurchaseAmount purchaseAmount){
        return Lottos.create(purchaseAmount.getQuantity());
    }

    public List<LottoDto> getPurchaseLottos(final Lottos purchaseLottos){
        List<Lotto> lottos = purchaseLottos.getLottos();
        return lottos.stream()
                .map(lotto -> LottoDto.create(lotto.getNumbers()))
                .collect(Collectors.toList());
    }
}
