package lotto.view;

import java.util.List;

public class LottoOutput {

    public String requestAmountMessage() {
        return "구매금액을 입력해 주세요.";
    }

    public String printNumberOfTicketsMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public String getLottoNumbersMessage(List<Integer> lottoNumbers) {
        return lottoNumbers.toString();
    }

    public String getErrorMessage(String message) {
        return message;
    }
}
