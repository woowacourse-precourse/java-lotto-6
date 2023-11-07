package lotto.utility;

public class RetryLogic {

    private static final int MAX_RETRIES = 5;
    private static final String TIME_OUT = "최대 시도 횟수가 초과되었습니다.";

    public static void retryCount(Retry retry) {
        for (int i = 1; i <= MAX_RETRIES; i++) {
            try {
                retry.run();
                break;
            } catch (IllegalArgumentException e) {
                if (i == MAX_RETRIES) {
                    System.out.println(TIME_OUT);
                    throw e;
                }
            }
        }
    }
}
