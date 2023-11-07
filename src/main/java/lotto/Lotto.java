package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    Message message = new Message();

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void playLotto() {
        int money = 0;
        int purchaseNumber = 0;
        int bonusInput = 0;
        List<List<Integer>> allNumbers = new ArrayList<>();
        money = purchaseResult(purchaseNumber, money, allNumbers);
        winnersNumber();
        bonusNumber();

    }

    // 구입 금액 입력 받고 예외 처리한 뒤 리턴
    public int purchaseResult(int purchaseNumber, int money, List<List<Integer>> allNumbers) {
        message.purchaseMessage();
        try {
            int moneyInput = Integer.parseInt(Console.readLine());
            money = validateOfMoney(moneyInput);
            purchaseNumber = calculatePurchaseNumber(money);
            System.out.println();
            System.out.println(purchaseNumber + "개를 구매했습니다.");
            printNumbers(purchaseNumber, allNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            System.out.println();
            return purchaseResult(0, 0, allNumbers); //예외 발생 시 기존 값 초기화 해줌
        }

        return money;
    }

    private int validateOfMoney(int moneyInput) {
        //1000단위의 숫자만 입력 받음
        if (moneyInput % 1000 != 0 || moneyInput < 1000) {
            throw new IllegalArgumentException();
        }

        return moneyInput;
    }

    private int calculatePurchaseNumber(int money) {
        return money / 1000;
    }

    public void printNumbers(int purchaseNumber, List<List<Integer>> allNumbers) {
        //로또 숫자 6자리 출력
        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumber);
            System.out.println(randomNumber);
            allNumbers.add(randomNumber);
        }
    }

    private void winnersNumber() {
        System.out.println();
        message.winningNumberMessage();

        String numberInput = Console.readLine();
        String[] numbersInput = numberInput.split(",");

        try {
            //Integer로 타입 변환 후 리스트에 저장
            for (String number : numbersInput) {
                int typeChange = Integer.parseInt(number.trim());
                numbers.add(typeChange);
            }
            //예외 검사
            validateOfNumbers(numbers, numberInput);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            winnersNumber();
        }

    }

    private void validateOfNumbers(List<Integer> numbers, String numberInput) {
        // 로또 번호를 6개보다 적게 또는 많이 입력 했을 경우
        if (numbers.size() != 6) {
            numbers.clear();
            throw new IllegalArgumentException();

        } else if (false == doubleCheck()) {
            numbers.clear();
            throw new IllegalArgumentException();
        }
    }

    private boolean doubleCheck() {
        Set<Integer> numberSet = new HashSet<>(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            //중복 찾기
            if (numberSet.size() != numbers.size()) {
                return false;
            }
            //숫자 범위 제한
            if (numbers.get(i) < 0 || numbers.get(i) > 45) {
                return false;
            }
        }

        return true;
    }

    private void bonusNumber() {
        System.out.println();
        message.bonusNumberMessage();
        try {
            int bonusInput = Integer.parseInt(Console.readLine());
            //중복 검사
            if (numbers.contains(bonusInput)) {
                throw new IllegalArgumentException();
            }
            // 숫자 범위 지정
            if (bonusInput < 0 || bonusInput > 45) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            bonusNumber();
        }
    }
}
