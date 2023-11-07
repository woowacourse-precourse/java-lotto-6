package lotto.view.service;

import lotto.lotto.dto.LottoDto;

import java.util.List;

public interface ViewOutputService {

    void printPurchasedCount(List<LottoDto> lottoDtos);
}
