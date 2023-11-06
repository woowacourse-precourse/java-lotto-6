package lotto;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toHexString;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int cash = getPurchaseAmount(); // 구매 금액 입력 : 입력한 현금 금액 ex) 14000
            int numberOfLotto = calculateNumberOfLotto(cash); // 구매한 로또 개수 출력
            System.out.println(numberOfLotto + "개를 구매했습니다.");

            // Lotto 클래스 타형 인스턴스를 보관할 lottoes 배열 생성
            List<Lotto> lottos = buyLottos(numberOfLotto);

            // 구매한 로또 번호 출력
            for (Lotto lotto : lottos) {
                System.out.println(lotto.getNumbers());
            }

            List<Integer> winningNumbers = getWinningNumbers(); // 당첨 번호 입력
            System.out.println();
            int bonus = getBonusNumber(); // 보너스 점수 입력

            int[] matchCounts = checkMatchingCounts(lottos, winningNumbers, bonus);

            printWinningStats(matchCounts);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }


    private static int getPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseInt(input);
    }

    private static int calculateNumberOfLotto(int cash) { // 입력한 금액을 로또로 환산
        if (cash < 1000) {
            throw new IllegalArgumentException("로또는 1000원 이상부터 구매 가능합니다.");
        }
        if (cash % 1000 != 0) {
            throw new IllegalArgumentException("로또는 천 원 단위로만 구매 가능합니다.");
        }
        return cash / 1000;
    }

    private static List<Lotto> buyLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        //구매한 로또 개수만큼 숫자 뽑아내기
        for (int i = 0; i < numberOfLotto; i++) {
            // 1~45 까지의 수 랜덤 뽑기
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);  // 뽑은 숫자를 가진 Lotto 클래스 객체 lotto 생성
            Collections.sort(numbers); // 로또 번호를 오름차순으로 정렬
            lottos.add(lotto); // lottoes 배열에 개별 lotto 들을 추가
        }
        return lottos;
    }

    // 당첨 번호 입력
    private static List<Integer> getWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningInput = Console.readLine();
        return parseNumbers(winningInput);
    }

    // 보너스 번호 입력
    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        return parseInt(bonusInput);
    }

    // 일치 조건 찾기
    private static int[] checkMatchingCounts(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        int[] matchCounts = new int[8]; // 일치하는 숫자 개수를 담는 배열
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers); //당첨 번호와 몇개가 일치하는 지. ex) 5개가 일치한다.
            boolean hasBonus = lotto.getNumbers().contains(bonus); //보너스 숫자를 포함하는지 ex) 보너스 점수도 맞다
            matchCounts[getMatchIndex(matchCount, hasBonus)]++; // ex) 5개가 일치하므로 6번 인덱스에 +1
        }
        return matchCounts;
    }

    // 일치 조건 출력
    private static void printWinningStats(int[] matchCounts) {
        // 결과 출력
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        int[] prizeMoney = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000}; // 각 등수별 상금 (0, 1, 2, 3, 4, 5, 5+b, 6) - 5+b 는 인덱스 6, 6은 7번 인덱스
        String[] prizeNames = {"", "", "", "(5,000원)", "(50,000원)", "(1,500,000원)", "(30,000,000원)", "(2,000,000,000원)"}; // 0, 1, 2, 3, 4, 5, 5+b, 6

        for (int i = 3; i < matchCounts.length; i++) {
            int count = matchCounts[i];
            if (i <= 5) { //3~5개가 일치할 경우
                System.out.println(i + "개 일치 " + prizeNames[i] + " - " + count + "개");
            }
            if (i == 6) { //5개가 일치하고, 보너스볼이 일치
                System.out.println("5 개 일치, 보너스 볼 일치 " + prizeNames[i] + " - " + count + "개");
            }
            if (i == 7) { //6개가 모두 맞을 경우
                System.out.println("6 개 일치 " + prizeNames[i] + " - " + count + "개");
            }
        }

        // 수익 계산
        double totalPrize = calculateTotalPrize(matchCounts, prizeMoney);
        double totalCost = matchCounts[0] * 1000; // 1장당 1000원
        double profitRate = ((totalPrize - totalCost) / totalCost) * 100.0;
        profitRate = Math.round(profitRate * 10) / 10.0; // 소수점 둘째 자리에서 반올림

        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }


    private static List<Integer> parseNumbers(String input) {
        String[] numbersStr = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbersStr) {
            numbers.add(parseInt(number.trim()));
        }
        return numbers;
    }

    // 일치하는 번호 개수를 계산하는 메서드
    private static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 인덱스 배정하기
    private static int getMatchIndex(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) { //5개가 일치하고, 보너스 숫자까지 일치하면
            return 6;  // 인덱스 6번에 배정
        }
        if (matchCount == 6) {  //6개가 전부 일치할 경우
            return 7; // 인덱스 7번에 배정
        }
        return matchCount;
    }

    private static double calculateTotalPrize(int[] matchCounts, int[] prizeMoney) {
        double totalPrize = 0;
        for (int i = 3; i < matchCounts.length; i++) {
            totalPrize += matchCounts[i] * prizeMoney[i];
        }
        return totalPrize;
    }
}

