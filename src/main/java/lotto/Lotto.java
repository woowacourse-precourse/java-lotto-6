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
        compare(money, bonusInput, allNumbers);
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

    private void compare(int money, int bonusInput, List<List<Integer>> allNumbers) {
        List<Integer> reduplicationNumber = new ArrayList<>();
        int bonus = 0;
        //로또 번호 리스트 가져 와서 당첨 번호와 비교 후 중복 되는 갯수 reduplicationNumber 리스트에 저장
        for (List<Integer> sub : allNumbers) {
            sub.retainAll(numbers);
            reduplicationNumber.add(sub.size());
            // 5개 + 보너스 볼 일 때
            if (sub.size() == 5 && sub.contains(bonusInput)) {
                bonus += 1;
            }
        }
        int threeFrequency = Collections.frequency(reduplicationNumber, 3);
        int fourFrequency = Collections.frequency(reduplicationNumber, 4);
        int fiveFrequency = Collections.frequency(reduplicationNumber, 5);
        int sixFrequency = Collections.frequency(reduplicationNumber, 6);

        System.out.println();
        message.statisticsMessage();
        calculateWinning(money, threeFrequency, fourFrequency, fiveFrequency, sixFrequency, bonus);
    }

    private void calculateWinning(int money, int threeFrequency, int fourFrequency, int fiveFrequency, int sixFrequency, int bonus) {
        int total = (threeFrequency * Winning.THREE.getWinnings()) + (fourFrequency * Winning.FOUR.getWinnings()) + (fiveFrequency * Winning.FIVE.getWinnings()) + (bonus * Winning.FIVE_BONUS.getWinnings()) + (sixFrequency * Winning.SIX.getWinnings());
        double rateOfReturn = ((double) total / money) * 100;
        double decimalPoint = Math.round(rateOfReturn * 1000) / 1000.0;

        System.out.println("3개 일치 " + Winning.THREE.getNumber() + " - " + threeFrequency + "개");
        System.out.println("4개 일치 " + Winning.FOUR.getNumber() + " - " + fourFrequency + "개");
        System.out.println("5개 일치 " + Winning.FIVE.getNumber() + " - " + fiveFrequency + "개");
        System.out.println("5개 일치, 보너스 볼 일치 " + Winning.FIVE_BONUS.getNumber() + " - " + bonus + "개");
        System.out.println("6개 일치 " + Winning.SIX.getNumber() + " - " + sixFrequency + "개");
        System.out.println("총 수익률은 " + decimalPoint + "%입니다.");
    }
}

enum Winning {  //당첨금 저장
    THREE("(5,000원)", 5000),
    FOUR("(50,000원)", 50000),
    FIVE("(1,500,000원)", 1500000),
    FIVE_BONUS("(30,000,000원)", 30000000),
    SIX("(2,000,000,000원)", 200000000);
    private final int winnings;
    private final String number;

    Winning(String number, int winnings) {
        this.number = number;
        this.winnings = winnings;
    }

    public String getNumber() {
        return number;
    }

    public int getWinnings() {
        return winnings;
    }
}

