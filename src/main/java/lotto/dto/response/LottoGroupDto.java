package lotto.dto.response;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGroup;

public class LottoGroupDto {
    private final int size;
    private final List<LottoDto> lottos;

    private LottoGroupDto(int size, List<LottoDto> lottos) {
        this.size = size;
        this.lottos = lottos;
    }

    public static LottoGroupDto from(LottoGroup lottoGroup) {
        List<Lotto> purchasedLottos = lottoGroup.getPurchasedLottos();
        List<LottoDto> lottoDtos = toLottoDtos(purchasedLottos);

        return new LottoGroupDto(purchasedLottos.size(), lottoDtos);
    }

    private static List<LottoDto> toLottoDtos(List<Lotto> purchasedLottos) {
        return purchasedLottos.stream()
                .map(LottoDto::from)
                .toList();
    }

    public int getSize() {
        return size;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
