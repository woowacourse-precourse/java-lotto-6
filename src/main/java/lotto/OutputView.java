package lotto;

import java.util.Collections;
import java.util.List;
import lotto.config.LottoGameMessage;

public class OutputView {

    private static final String DELIMITER = ", " ;

    public OutputView(OutputWriter outputWriter) {
    }

    public static void printPurchasedLottos(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.getNumbers();
        Collections.sort(numbers);
        System.out.println(String.join(DELIMITER, numbers.toString()));
    }

    public void printPurchasedLottoSize(int purchased) {
        System.out.println(purchased + LottoGameMessage.OUTPUT_PURCHASED_LOTTO_SIZE.message());
    }
}
