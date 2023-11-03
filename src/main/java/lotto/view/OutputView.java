package lotto.view;

import lotto.model.dto.LottoResponseDto;

import static lotto.constants.Phrase.OUTPUT_LOTTO_AMOUNT;

public class OutputView {
    public static void printPlayerAmount(int amount) {
        System.out.println("\n" + amount + OUTPUT_LOTTO_AMOUNT.getPhrase());
    }

    public static void printPlayerLotto(LottoResponseDto lottoResponseDto) {
        System.out.println(lottoResponseDto.createLottoMessage());
    }
}
