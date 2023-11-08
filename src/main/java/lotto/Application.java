package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // 로또 게임 실행 로직을 여기에 구현합니다.
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = purchaseLottos(numberOfLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        // 결과 출력
        printLottos(lottos);
        printWinningStatistics(lottos, winningNumbers, bonusNumber);
    }

    private static int getPurchaseAmount() {
        // 구매 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine().trim());
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> purchaseLottos(int numberOfLottos) {
        // 로또 구매
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private static List<Integer> getWinningNumbers() {
        // 당첨 번호 입력 받기
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = Console.readLine().split(",");
        return validateAndParseNumbers(winningNumberStrings);
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        // 보너스 번호 입력 받기
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 유효한 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    private static List<Integer> validateAndParseNumbers(String[] numberStrings) {
        // 입력 번호 유효성 검증 및 파싱
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        return numbers;
    }

    private static void printLottos(List<Lotto> lottos) {
        // 구매한 로또 출력
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    private static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        // 당첨 통계 출력
        // 여기에 당첨 결과 계산 및 출력 로직을 구현합니다.
    }

    // 여기에 필요한 추가 메서드를 구현합니다.
}