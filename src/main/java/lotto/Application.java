package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Application {

    static final int PRICE = 1000;
    static int purchasePrice;
    static int ticketAmount;
    static ArrayList<List<Integer>> lottos = new ArrayList<>();
    static String[] inputNumbers;
    static int BonusNumber;
    static List<Integer> winningNumbers = new ArrayList<>();

    static boolean overlapExist = false;
    static boolean isRightRange = true;

    static int matchRecord = 0;
    static int[] lottoRecord = new int[8];

    static DecimalFormat formatter = new DecimalFormat("###,###");

    public enum Grade {
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);
        private final int PRIZE;

        private Grade(int prize) {
            this.PRIZE = prize;
        }

        public int getPrize() {
            return this.PRIZE;
        }
    }

    static Grade grade;
    static List<Grade> grades = new ArrayList<>();

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            purchasePrice = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 숫자로 입력하시오");
            getMoney();
        }
        return purchasePrice;
    }

    public static void getLotteryTickets(int money, int PRICE) {
        int amount = money / PRICE;
        ticketAmount = amount;
    }

    public static void checkValidatePrice(int money, int PRICE) {
        try {
            if (money % PRICE != 0)
                throw new IllegalArgumentException("[ERROR] 구매금액이 나누어 떨어지지 않음");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoney();
        }
    }

    static void createLotto() {
        for (int i = 0; i < ticketAmount; i++) {
            //  1.로또 번호 랜덤 뽑기
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            // 2. 로또 번호 오름차순 정렬
            Collections.sort(lottoNumbers);
            // 3. 로또 집합에 추가
            lottos.add(lottoNumbers);
            // 4. 로또 생성
            Lotto lotto = new Lotto(lottoNumbers);
        }
    }

    public static void printLottoNumbers() {
        System.out.println("\n" + ticketAmount + "개를 구매했습니다.");
        for (int i = 0; i < ticketAmount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public static void getInput() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        inputNumbers = Console.readLine().split(",");
        try{
        }catch(PatternSyntaxException e) {
            try{
                throw new IllegalArgumentException("[ERROR] 쉼표로 구분지어 입력하시오");
            }catch (IllegalArgumentException e1){
                e1.getMessage();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 정확히 숫자로 입력하시오");
        }
    }

    private static void validateNumber(String[] input) {
        try {
            if (input.length != 6)
                throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아님" +
                        "");
        } catch (IllegalArgumentException e) {
            e.getMessage();
            getInput();
        }
    }

    public static void getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해주세요.");
        try{
        BonusNumber = Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 정확히 숫자로 입력");
        }
    }

    public static List<Integer> input2WinnigNumber(String[] inputNumbers) {
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    static boolean validateRange() {
        for (int num : winningNumbers) {
            if (num < 1 || num > 45)
                isRightRange = false;
            if(BonusNumber < 1 || BonusNumber > 45)
                isRightRange = false;
        }
        return isRightRange;
    }

    private static boolean checkOverlappedNumber() {
        for (int num : winningNumbers) {
            int overlapTime = Collections.frequency(winningNumbers, num);
            if (overlapTime > 1)
                overlapExist = true;
            if(num == BonusNumber)
                overlapExist = true;
        }
        return overlapExist;
    }

    static void occurException() {
        try{
            if (overlapExist)
                throw new IllegalArgumentException("[ERROR] 중복 숫자 존재");
            if (isRightRange == false)
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 이내 범위가 아닌 숫자가 있음");
        }catch (IllegalArgumentException e){
            e.getMessage();
            getInput();
        }
    }

    static void compareNumbers(List<Integer> lotto) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (Collections.frequency(lotto, winningNumbers.get(i)) != 0) //  i번째 로또에 당첨번호의 요소가 있는가
                matchRecord += 1;
        }
    }

    public static void getLottoRecord() {
        for (int i = 0; i < lottos.size(); i++) {
            // 당첨 일치 개수 구하기
            //compareNumbers(lottos.get(i));
            lottoRecord[i] = matchRecord;
            matchRecord = 0;
        }
    }

    static void getWinningStat() {
        for (int i = 0; i < lottos.size(); i++) {
            grade = null;
            if (lottoRecord[i] == 3)
                grade = Grade.FIFTH;
            if (lottoRecord[i] == 4)
                grade = Grade.FOURTH;
            if (lottoRecord[i] == 5)
                grade = Grade.THIRD;
            if (lottoRecord[i] == 5 && lottos.get(i).contains(BonusNumber))
                grade = Grade.SECOND;
            if (lottoRecord[i] == 6)
                grade = Grade.FIRST;
            grades.add(grade);
        }
    }

    public static void printWinningStat() {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (" + formatter.format(Grade.FIFTH.PRIZE) + ")원 - "
                + Collections.frequency(grades, Grade.FIFTH) + "개");
        System.out.println("4개 일치 (" + formatter.format(Grade.FOURTH.PRIZE) + ")원 - "
                + Collections.frequency(grades, Grade.FOURTH) + "개");
        System.out.println("5개 일치 (" + formatter.format(Grade.THIRD.PRIZE) + ")원 - "
                + Collections.frequency(grades, Grade.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + formatter.format(Grade.SECOND.PRIZE) + ")원 - "
                + Collections.frequency(grades, Grade.SECOND) + "개");
        System.out.println("6개 일치 (" + formatter.format(Grade.FIRST.PRIZE) + ")원 - "
                + Collections.frequency(grades, Grade.FIRST) + "개");
    }

    public static double getEarningRate() {
        List<Integer> earning = new ArrayList<>();
        int earningSum = 0;
        for (Grade g : Grade.values()) {
            earning.add(g.PRIZE * Collections.frequency(grades, g));
        }
        for (int i = 0; i < 5; i++) {
            earningSum += earning.get(i);
        }
        double earningRate = (double) earningSum / (double) purchasePrice * 100;
        return earningRate;
    }

    public static void printEarningRate(double rate) {
        //double result = Math.round(rate * 100) / 100.0;
        String result = String.format("%.1f", rate);
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        getLotteryTickets(getMoney(), PRICE);
        checkValidatePrice(purchasePrice, PRICE);

        createLotto();
        printLottoNumbers();

        getInput();
        getBonusNumber();

        input2WinnigNumber(inputNumbers);

        validateNumber(inputNumbers);
        validateRange();
        checkOverlappedNumber();;
        occurException();

        getLottoRecord();

        getWinningStat();
        printWinningStat();

        printEarningRate(getEarningRate());
    }
}

