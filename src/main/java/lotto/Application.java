package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
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
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        // 숫자 범위 미달, 초과 예외 처리
        if (lottoNumber.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 다시 입력해주세요.");
        }
        // 숫자 중복 예외 처리
        for (int p = 0; p < 5; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 1])) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
        for (int p = 0; p < 4; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 2])) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
        for (int p = 0; p < 3; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 3])) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
        for (int p = 0; p < 2; p++) {
            if (lottoNumber[p].equals(lottoNumber[p + 4])) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
        int p = 0;
        if (lottoNumber[p].equals(lottoNumber[p + 5])) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        // Null값 예외 처리
        for (int w=0; w<6; w++) {
            if (lottoNumber[p].equals(" ")) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }

        // 당첨 번호 배열 Int값으로 변경
        int[] intLottoNumber = new int[lottoNumber.length];
        for (int i = 0; i < lottoNumber.length; i++) {
            intLottoNumber[i] = Integer.parseInt(lottoNumber[i]);
        }
    }
}
