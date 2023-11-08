package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Price price = new Price(); //로또 구입 금액 객체
        int ticket = 0; //로또 몇 장 사는지 저장하는 변수

        LottoGenerator lottoGenerator = new LottoGenerator(); //로또 생성 객체
        List<Lotto> allLotto; //사용자가 산 로또 장수만큼 모든 로또를 담는 리스트

        Winning winning = new Winning(); //당첨 번호 입력, 저장하는 객체

        Result checkedResult; //통계 결과 객체

        Profit profit = new Profit(); //수익률 객체
        double rounding; //수익률을 소수점 둘째자리까지 저장하는 변수

        System.out.println("구입금액을 입력해 주세요.");
        price.inputPrice();

        ticket = price.getTicket();

        //로또 생성
        allLotto = lottoGenerator.generateLotto(ticket);

        System.out.println(ticket + "개를 구매했습니다.");
        printBoughtLotto(allLotto);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        winning.inputNumbers();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        winning.inputBonusNumber();

        checkedResult = winning.checkWinning(allLotto, winning);

        printWinningStatistics();

        rounding = profit.getRounding(price, checkedResult);
        System.out.println("총 수익률은 "+ rounding + "%입니다.");
    }

    private static void printBoughtLotto(List<Lotto> allLotto) {
        for (Lotto l : allLotto) {
            System.out.println(l.getSortedNumbers());
        }
    }

    private static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Result result : Result.values()) {
            System.out.println(result.getMessage() + " - " + result.getCount() + "개");
        }
    }
}
