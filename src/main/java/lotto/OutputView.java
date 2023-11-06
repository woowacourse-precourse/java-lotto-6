package lotto;

import java.util.List;

class OutputView {

    private static final String PRINT_ISSUANCE_RESULT_SIZE_FORMAT = "%n%d개를 구매했습니다.%n";

    public static void printIssuanceResult(List<List<Integer>> issuanceResult) {
        printIssuanceResultSize(issuanceResult);
        printIssuanceResultAll(issuanceResult);
        printPadding();
    }

    private static void printIssuanceResultSize(List<List<Integer>> issuanceResult) {
        System.out.format(PRINT_ISSUANCE_RESULT_SIZE_FORMAT, issuanceResult.size());
    }

    private static void printIssuanceResultAll(List<List<Integer>> issuanceResult) {
        issuanceResult.forEach(System.out::println);
    }

    private static void printPadding() {
        System.out.println();
    }
}
