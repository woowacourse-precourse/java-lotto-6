package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import domain.ErrorMessage;

public class Application {
    public static void main(String[] args) {

        // 구입 금액 입력
        double money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                money = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
        System.out.println();

        // 구입 로또 갯수 출력
        double lottoTicket = money / 1000;
        double lottoTicketComparison = money / 1000;
        if (lottoTicket != Math.round(lottoTicketComparison)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.toString());
        }
        System.out.println(Math.round(lottoTicket) + "개를 구매했습니다.");

        // 입력한 금액 만큼의 로또 발행
        List<List<Integer>> saveNumber = new ArrayList<>();
        for (int i = 0; i < lottoTicket; i++) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            saveNumber.add(randomNumber);
        }
        for (List<Integer> lottoBox : saveNumber) {
            List<Integer> purchaseNumber = new ArrayList<>(lottoBox);
            Collections.sort(purchaseNumber);
            System.out.println(purchaseNumber);
        }
        System.out.println();

        // 당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputlottoNumber = Console.readLine();
        String[] lottoNumber = inputlottoNumber.split(",");

        // 1~45가 아닌 숫자를 입력했을 때
        for (int q=0; q<6; q++) {
            if (Integer.parseInt(lottoNumber[q]) < 1 || Integer.parseInt(lottoNumber[q]) > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toString());
            }
        }

        // 숫자 범위 미달, 초과 예외 처리
        if (lottoNumber.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT_CNT.toString());
        }

        // 숫자 중복 예외 처리
        for (int p = 0; p < 5; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 1])) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
            }
        }
        for (int p = 0; p < 4; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 2])) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
            }
        }
        for (int p = 0; p < 3; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 3])) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
            }
        }
        for (int p = 0; p < 2; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 4])) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
            }
        }
        int p = 0;
        if (lottoNumber[p].equals(lottoNumber[p + 5])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
        }

        // Null값 예외 처리
        for (int w=0; w<6; w++) {
            if (lottoNumber[p].equals(" ")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.toString());
            }
        }

        // 당첨 번호 배열 Int값으로 변경
        int[] intLottoNumber = new int[lottoNumber.length];
        for (int i = 0; i < lottoNumber.length; i++) {
            intLottoNumber[i] = Integer.parseInt(lottoNumber[i]);
        }

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String lottoBonusNumber = Console.readLine();
        for (int b = 0; b < 6; b++) {
            if (Integer.parseInt(lottoNumber[b]) == Integer.parseInt(lottoBonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 겹칠 수 없습니다.");
            }
        }
        System.out.println();

        // 당첨 결과 추출
        int firstPrize = 0;
        int secondPrize = 0;
        int thirdPrize = 0;
        int fourthPrize = 0;
        int fifthPrize = 0;

        for (int i=0; i<lottoTicket; i++) {
            int lucky = 0;
            int bonus = 0;
            int bonusFailed = 0;

            if (saveNumber.get(i).contains(intLottoNumber[0])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(intLottoNumber[1])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(intLottoNumber[2])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(intLottoNumber[3])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(intLottoNumber[4])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(intLottoNumber[5])) {
                lucky ++;
            }
            if (saveNumber.get(i).contains(Integer.parseInt(lottoBonusNumber))) {
                bonus ++;
            } else if (!saveNumber.get(i).contains(Integer.parseInt(lottoBonusNumber))) {
                bonusFailed++;
            }

            if (lucky == 6) {
                firstPrize ++;
            }
            if (lucky == 5 && bonus == 1) {
                secondPrize ++;
            }
            if (lucky == 5 && bonusFailed == 1) {
                thirdPrize ++;
            }
            if (lucky == 4) {
                fourthPrize ++;
            }
            if (lucky == 3) {
                fifthPrize ++;
            }
        }

        // 수익률 추출
        double earningRate = (firstPrize*2000000000 + secondPrize*30000000 + thirdPrize*1500000 + fourthPrize*50000 + fifthPrize*5000)/money*100;

        // 당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthPrize + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthPrize + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdPrize + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPrize + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstPrize + "개");
        System.out.print("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
