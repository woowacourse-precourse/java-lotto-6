package lotto.view.service;

import lotto.lotto.dto.LottoDto;
import lotto.view.message.OutputMessage;

import java.util.List;

public class ViewOutputServiceImpl implements ViewOutputService {

    @Override
    public void printPurchasedCount(List<LottoDto> lottoDtos) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(lottoDtos.size()).append(OutputMessage.MESSAGE_PURCHASED_COUNT.getValue()).append('\n');

        for (LottoDto lottoDto : lottoDtos) {
            sb.append(lottoDto.getNumbers()).append('\n');
        }
        System.out.println(sb);
    }
}
