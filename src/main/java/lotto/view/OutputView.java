package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.LottoAmount;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printLottoNumber(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<numbers.size()-1; i++) {
            sb.append(numbers.get(i)).append(", ");
        }
        System.out.println(sb.append(numbers.get(numbers.size()-1)).append("]").toString());
    }

    public void printLottoAmount(LottoAmount lottoAmount) {
        System.out.println(String.format(Message.OUTPUT_LOTTO_AMOUNT.message, lottoAmount.getLottoAmount()));
    }

    private enum Message {
        OUTPUT_LOTTO_AMOUNT("%d개를 구매했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}