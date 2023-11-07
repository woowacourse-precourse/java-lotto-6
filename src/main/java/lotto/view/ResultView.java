package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class ResultView {

    /**
     * 구매한 로또 티켓을 출력하는 메소드입니다.
     *
     * @param lottos 구매한 로또 티켓 목록
     */
    public static void printPurchasedLottos(List<Lotto> lottos) {
        // TODO: 구매한 로또 티켓 출력 로직 구현
    }

    /**
     * 당첨 결과를 출력하는 메소드입니다.
     *
     * @param results 당첨 결과
     */
    public static void printWinningResults(/* TODO: 당첨 결과 타입 */) {
        // TODO: 당첨 결과 출력 로직 구현
    }

    /**
     * 총 수익률을 출력하는 메소드입니다.
     *
     * @param yield 수익률
     */
    public static void printYield(double yield) {
        // TODO: 수익률 출력 로직 구현
    }

    /**
     * 에러 메시지를 출력하는 메소드입니다.
     *
     * @param message 에러 메시지
     */
    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
