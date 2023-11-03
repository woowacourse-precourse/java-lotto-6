package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.InputDto;
import lotto.dto.LottoDto;
import lotto.model.repository.LottoRepository;

public class LottoService {
    private final LottoRepository lottoRepository;

    private static final int LOTTO_PRICE = 1000;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
    }

    public void createLottos(InputDto inputDto) {
        int lottoCount = getLottoCount(inputDto.getLottoPurchaseAmount());

        while (lottoCount > 0) {
            lottoRepository.save(new LottoDto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            lottoCount--;
        }
    }

    private static int getLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }
}
