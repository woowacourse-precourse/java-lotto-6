package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현 
        int amountOfLotto = setAmountOfLotto(-1);
        List<List<Integer>> LottoNumbers = generateLottoNumbers(amountOfLotto);
        printLottoNumbers(amountOfLotto, LottoNumbers);
        
        Lotto winningNumber = setWinningLotto();
        int bonusNumber = getBonusNumber(winningNumber);
        
        compareLottoNumbers(LottoNumbers, winningNumber, bonusNumber);
        MatchResult.printMatchResult(amountOfLotto);
    }
    public static void printLottoNumbers(int amountOfLotto, List<List<Integer>> LottoNumbers){
        System.out.println(amountOfLotto + "개를 구매했습니다.\n");
        for(List<Integer> numbers : LottoNumbers){
            System.out.println(numbers);
        }
    }
    //금액 입력받기
    public static int setAmountOfLotto(int amountOfLotto){
        while (amountOfLotto == -1) {
            amountOfLotto = parseAmount(Console.readLine());
        }
        return amountOfLotto;
    }
    private static int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            amount = validateInput(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return -1; // 유효하지 않은 입력에 대해 -1 반환
    }
    public static int validateInput(int amountOfLotto){
        if(amountOfLotto <= 0 || amountOfLotto % 1000 != 0){
            throw new IllegalArgumentException("로또는 1000원 단위로 적어야합니다.");
        }
        return amountOfLotto / 1000;
    }
    public static List<List<Integer>> generateLottoNumbers(int amount){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < amount ; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        
        return lottoNumbers;
    }
    
    //당첨 번호 입력받기
    public static Lotto setWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        return new Lotto(winningNumbers);
    }
    
    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.print("당첨 번호를 입력하세요 (쉼표로 구분된 6개의 숫자): \n");
                List<Integer> winningNumbers = parseNumbers(Console.readLine());
                new Lotto(winningNumbers); // 당첨 번호 유효성 검사
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage()); // Lotto 생성 시 발생하는 예외 메시지 출력
            }
        }
    }
    
    private static int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                int bonusNumber = setBonusNumber(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static List<Integer> parseNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                numbers.add(number);
                // isValidBonusNumber(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] : 올바른 숫자 형식이 아닙니다.");
            }
        }
        return numbers;
    }
    //보너스 번호 입력받기
    private static int setBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.print("보너스 번호를 입력하세요 (1부터 45 사이의 숫자)\n");
                int bonusNumber = Integer.parseInt(Console.readLine().trim());
                isValidBonusNumber(bonusNumber);    
                winningNumbers.contains(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자 형식이 아닙니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static void isValidBonusNumber(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
}

    public enum MatchResult {
        ZERO(0, "0", 0),
        TWO(2, "0", 0),
        ONE(1, "0", 0),
        THREE(3, "5,000원", 5000),
        FOUR(4, "50,000원", 50000),
        FIVE(5, "1,500,000원", 1500000),
        FIVEandBONUS(7, "30,000,000원", 30000000),
        SIX(6, "2,000,000,000원", 2000000000);

        private final int matchedNumbers;
        private final int money;
        private final String price;

        private static final Map<MatchResult, Integer> matchCountMap = new EnumMap<>(MatchResult.class);

        static{
            for(MatchResult result : MatchResult.values()){
                matchCountMap.put(result, 0);
            }
        }

        public static void incrementMatchCount(MatchResult result){
            matchCountMap.put(result, matchCountMap.get(result) + 1);
        }
        
        public static void printMatchResult(int amountOfLotto){
            double sum = 0;
            for (MatchResult result : MatchResult.values()) {
                if (result.getMatchedNumbers() >= 3 && result.getMatchedNumbers() <= 6) {
                    System.out.println(result.getMatchedNumbers() + "개 일치 (" + result.price + ") - " + matchCountMap.get(result) + "개");
                    sum = isWinningAndPlusMoney(sum, result);
                }
                if(result.getMatchedNumbers() == 7){
                    System.out.println("5개 일치, 보너스 볼 일치 (" + result.price + ") - " + matchCountMap.get(result) + "개");
                    sum = isWinningAndPlusMoney(sum, result);
                }
            }
            Rounds(sum, amountOfLotto);
        }
        public static double isWinningAndPlusMoney(double sum, MatchResult matchResult){
            if(matchResult.matchedNumbers >= 1){
                return sum + matchResult.money * matchCountMap.get(matchResult);
            }
            return sum;
        }

        MatchResult(int matchedNumbers, String price, int money) {
            this.matchedNumbers = matchedNumbers;
            this.price = price;
            this.money = money;
        }
        //getter
        public int getMatchedNumbers() {
            return matchedNumbers;
        }
        public String getMatchedPrice() {
            return price;
        }

        public static MatchResult valueOfMatchedNumbers(int matchedNumbers) {
            for (MatchResult result : MatchResult.values()) {
                if (result.getMatchedNumbers() == matchedNumbers) {
                    return result;
                }
            }
            return ZERO; // 기본값
        }
    }
    public static void compareLottoNumbers(List<List<Integer>> lottoNumbers, Lotto winningNumbers, int bonusNumber) {
        for (List<Integer> oneLotto : lottoNumbers) {
            int matchCount = compareLottoNumbersList(oneLotto, winningNumbers, bonusNumber);
            MatchResult.incrementMatchCount(MatchResult.valueOfMatchedNumbers(matchCount));
        }
    }
    
    public static int compareLottoNumbersList(List<Integer> oneLotto, Lotto winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean isBonus = false;
        for (int number : oneLotto) {
            if (winningNumbers.contain(number)) {
                matchCount++;
            }
            if(bonusNumber == number){
                isBonus = true;
            }
        }
        if(matchCount == 5 && isBonus){
            return 7;
        }
        return matchCount;
    }
    
    public static void Rounds(double sum, int amountOfLotto){
        if(sum == 0){
            System.out.println("총 수익률은 " + sum + "%입니다.");            
            return;
        }
        sum = sum / ((double) amountOfLotto * 10);
        
        sum = Math.round(sum * 10) / 10.0;
        System.out.println("총 수익률은 " + sum + "%입니다.");
    }
}
