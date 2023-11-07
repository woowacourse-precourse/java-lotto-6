package lotto.game;

import lotto.domain.Lotto;

import java.util.List;

public class UserOutput {

    private static final String MONEY_INSERT = "구입금액을 입력해 주세요.";
    private static final String LOTTO_BUY = "{count}개를 구매했습니다.";
    private static final String TYPE_IN_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String TYPE_IN_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT = "당첨 통계" + "\n---";
    private static final String MATCH3 = "3개 일치 (5,000원) - {match3}개";
    private static final String MATCH4 = "4개 일치 (50,000원) - {match4}개";
    private static final String MATCH5 = "5개 일치 (1,500,000원) - {match5}개";
    private static final String MATCH5_A = "5개 일치, 보너스 볼 일치 (30,000,000원) - {match5A}개";
    private static final String MATCH6 = "6개 일치 (2,000,000,000원) - {match6}개";

    private static final String INVESTMENT_RESULT = "총 수익률은 {investmentResult}%입니다.";


    public static void inputMoney() {
        System.out.println(MONEY_INSERT);
    }

    public static void getLottoCount(String lottoCount) {
        System.out.println(LOTTO_BUY.replace("{count}", lottoCount));
    }

    public static void showLottos(Machine machine, List<Lotto> lottos) {
        for (int i = 0; i < machine.getCount(); i++) {
            System.out.println(lottos.get(i).getNumbers().toString());
        }
    }

    public static void inputWinningNumber() {
        System.out.println(TYPE_IN_WINNING_NUMBER);
    }

    public static void inputBonusNumber() {
        System.out.println(TYPE_IN_BONUS_NUMBER);
    }

    public static void getWinningResult() {
        System.out.println(WINNING_RESULT);
    }

    public static void getMatch3(String result) {
        System.out.println(MATCH3.replace("{match3}", result));
    }
    public static void getMatch4(String result) {
        System.out.println(MATCH4.replace("{match4}", result));
    }
    public static void getMatch5(String result) {
        System.out.println(MATCH5.replace("{match5}", result));
    }
    public static void getMatch5A(String result) {
        System.out.println(MATCH5_A.replace("{match5A}", result));
    }
    public static void getMatch6(String result) {
        System.out.println(MATCH6.replace("{match6}", result));
    }
    public static void getInvestmentResult(String rate) {
        System.out.println(INVESTMENT_RESULT.replace("{investmentResult}", rate));
    }

}
