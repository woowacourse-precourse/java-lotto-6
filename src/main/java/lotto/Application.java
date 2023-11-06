package lotto;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    private static int CalcCash(int cash) {  // 입력한 금액을 로또로 환산
        int numberOfLotto = 0;
        if (cash % 1000 == 0) {
            numberOfLotto = cash / 1000;
        }
        return numberOfLotto;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구매 금액 입력
        System.out.println("구매금액을 입력해 주세요.");
        String Input = Console.readLine();
        int cash = parseInt(Input); // 입력한 현금 금액 ex) 14000

        // 구매한 로또 개수 출력
        int numberOfLotto = CalcCash(cash);
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        // Lotto 클래스 타형 인스턴스를 보관할 lottoes 배열 생성
        List<Lotto> lottos = new ArrayList<>();

        //구매한 로또 개수만큼 숫자 뽑아내기
        for (int i = 0; i < numberOfLotto; i++) {
            // 1~45 까지의 수 랜덤 뽑기
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);  // 뽑은 숫자를 가진 Lotto 클래스 객체 lotto 생성
            Collections.sort(numbers); // 로또 번호를 오름차순으로 정렬
            lottos.add(lotto); // lottoes 배열에 개별 lotto 들을 추가
        }

        // 구매한 로또 번호 출력
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        // 당첨 번호 입력
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningInput = Console.readLine();
        String[] winningNumbersStr = winningInput.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumbersStr) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        System.out.println();

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        int bonus = parseInt(bonusInput);

        //담청 통계
        System.out.println("---");

        // 일치 조건 찾기








        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
