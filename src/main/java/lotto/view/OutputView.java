package lotto.view;

import lotto.dto.LottoesDto;
import lotto.util.PreviewSentence;

public class OutputView {
    public void beforeInputMoney() {
        System.out.println(PreviewSentence.INPUT_MONEY.getMessage());
    }

    public void printPurchasedLottoes(LottoesDto lottoesDto) {
        printLottoCount(lottoesDto);
        printGeneratedLottoes(lottoesDto);
    }

    private void printLottoCount(LottoesDto lottoesDto) {
        int lottoCount = lottoesDto.getLottoCount();
        System.out.print(PreviewSentence.LINE_SEPARATOR.getMessage());
        System.out.println(PreviewSentence.SAY_LOTTO_COUNT.getMessage(lottoCount));
    }

    private void printGeneratedLottoes(LottoesDto lottoesDto) {
        lottoesDto.lottoDtos()
                .forEach(dto -> System.out.println(dto.numbers()));
    }
}
