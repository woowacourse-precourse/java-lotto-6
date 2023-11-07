package lotto.service;

import lotto.dto.LottoDto;
import lotto.dto.LottoesDto;
import lotto.dto.MoneyDto;
import lotto.repository.LottoRepository;
import lotto.util.Consts;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoRepository lottoRepository = new LottoRepository();

    public LottoesDto purchaseLottoes(MoneyDto moneyDto) {
        int lottoesCount = calculateLottoCount(moneyDto.amount());
        List<LottoDto> lottoDtoes = generateLottoes(lottoesCount);
        return new LottoesDto(lottoDtoes);
    }

    private int calculateLottoCount(int money) {
        return money / Consts.SINGLE_LOTTO_PRICE.getValue();
    }

    private List<LottoDto> generateLottoes(int lottoesCount) {
        List<LottoDto> lottoDtos = new ArrayList<>(lottoesCount);
        for (int i = 0; i < lottoesCount; i++) {
            lottoDtos.add(lottoRepository.createLotto());
        }
        return lottoDtos;
    }
}
