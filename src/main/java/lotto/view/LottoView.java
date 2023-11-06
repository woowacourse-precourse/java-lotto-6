package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView { //게임 시작 메세지 출력, 구입 금액, 당첨 번호, 보너스 번호 입력 요청, 당첨 통계 및 결과 메세지 출력, 에러 메세지 출력

    private static final String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_PROMPT = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요";
    private static final String LOTTO_STATISTICS_HEADER = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String COUNT_PRIZE_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

}
