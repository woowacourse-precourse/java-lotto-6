package lotto;

import java.util.List;

class OutputView {

    private static final String PRINT_ISSUANCE_RESULT_FORMAT = "%n%d개를 구매했습니다.%n";

    public static void printIssuanceResult(List<List<Integer>> issuanceResult) {
        System.out.format(PRINT_ISSUANCE_RESULT_FORMAT, issuanceResult.size());

        issuanceResult.forEach(System.out::println);
    }
}
