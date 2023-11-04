package lotto.view;

import lotto.dto.PurchaseResult;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printPurchaseResult(List<PurchaseResult> purchaseResults) {
        System.out.printf(Constants.INPUT_MONEY.message, purchaseResults.size());
        purchaseResults
                .forEach(result -> System.out.println(result.lottoNumbers()));
    }

    private enum Constants {
        INPUT_MONEY("%d개를 구매했습니다.%n"),
        PICK_LOTTO_TICKET_NUMBER("당첨 번호를 입력해주세요.");

        private final String message;

        Constants(String message) {
            this.message = message;
        }
    }
}
