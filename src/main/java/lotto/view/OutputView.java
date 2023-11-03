package lotto.view;

import lotto.dto.LottoResponseDtos;
import lotto.dto.LottoResponseDtos.*;
import lotto.utils.NumberUtils;
import lotto.utils.constant.Constant;
import lotto.utils.message.Message;

public class OutputView {
    public void printLottos(int count, LottoResponseDtos lottoResponseDtos) {
        printLottoCount(count);
        printAllLotto(lottoResponseDtos);
    }

    private void printLottoCount(int count) {
        System.out.printf(Message.OUTPUT_LOTTO_COUNT, count);
    }

    private void printAllLotto(LottoResponseDtos lottoResponseDtos) {
        for (LottoResponseDto responseDto : lottoResponseDtos.getLottoResponseDtos()) {
            printLottoNumbers(responseDto);
        }
    }

    public void printLottoNumbers(LottoResponseDto responseDto) {
        String lotto = String.join(Constant.NUMBER_DELIMITER, NumberUtils.convertToString(responseDto.getLottoNumbers()));
        System.out.println("[" + lotto + "]");
    }
}
