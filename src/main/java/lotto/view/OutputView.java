package lotto.view;

import lotto.dto.LottoIssueResultDTO;

public class OutputView {

    private static final String START_INPUT_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String START_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static void printInputAmountMessage() {
        System.out.println(START_INPUT_AMOUNT);
    }

    public static void printInputWinningNumbersMessage() {
        System.out.println(START_INPUT_WINNING_NUMBERS);
    }

    public static void printError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static void printLottoIssueResult(LottoIssueResultDTO resultDTO) {
        System.out.println("\n" + resultDTO.getTicketCount() + "개를 구매했습니다.");
        resultDTO.getLottos()
                .forEach(System.out::println);
    }
}
