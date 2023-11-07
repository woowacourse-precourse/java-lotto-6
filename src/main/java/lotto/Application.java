package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static int sixMatchPrize;
    private static int fiveMatchWithBonusPrize;
    private static int fiveMatchPrize;
    private static int fourMatchPrize;
    private static int threeMatchPrize;

    private static double statistics;

    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        int inputMoney = inputMoney(money);

        int count = moneyReplaceCount(inputMoney);
        System.out.println("\n"+count+"개를 구매했습니다.");
        Map<Integer, List<Integer>> userCountRandomLotto = generateAndDisplayNumbers(count);
        printGenerateAndDisplayNumbers(userCountRandomLotto);

        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = readLine();
        List<Integer> pickWinnerNumber = inputWinningNumberVerification(inputWinningNumber(numbers));

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        Integer bonusNum = inputBounsNumber(pickWinnerNumber, bonusNumber);

        Map<Integer, Integer> matches = numberMatches(userCountRandomLotto, pickWinnerNumber);
        determinePrizeRank(userCountRandomLotto, matches, bonusNum);
        calculateProfitRate(inputMoney);
        printWinningStatistics();


    } // main

    public static Integer convertStringToInt(String str) throws NumberFormatException {
        return Integer.parseInt(str);
    }

    public static List<Integer> pickUniqueNumber(){ // 복권의 랜덤한 값을 출력한 후 반환
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Integer inputMoney(String money){ // 사용자가 뽑고 싶은 만큼 돈 투입
        while (true) {
            try {
                Integer userMoney = convertStringToInt(money);
                moneyDiscrimination(userMoney);
                return userMoney; // 유효한 입력이면 반환하고 메서드 종료
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            money = readLine(); // 새로운 입력을 받습니다.
        }
    } // inputMoney



    public static void moneyDiscrimination(Integer money){ // 입력한 돈이 맞게 들어왔는지 검증하는 메소드
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 투입하셨습니다. 다시 시도하세요.");
        }
    } // pickUniqueNumber

    public static int moneyReplaceCount(int money){ // 입력된 돈을 횟수로 치환하는 메소드
        return money/1000;
    } // moneyReplaceCount

    public static Map<Integer, List<Integer>> generateAndDisplayNumbers(int count){ // 횟수만큼 복권을 Map 객체에 저장

        Map<Integer, List<Integer>> pickNumbers = new Hashtable<>();

        for(int i=1; i<=count; i++){
            pickNumbers.put(i, pickUniqueNumber());
        }

        return pickNumbers;
    } // generateAndDisplayNumbers
    
    public static void printGenerateAndDisplayNumbers(Map<Integer, List<Integer>> pickNumbers){ // 횟수만큼 저장한 복권을 출력

        pickNumbers.forEach((key, value) -> {
            List<Integer> valueList = new ArrayList<>(value);
            Collections.sort(valueList);
            System.out.println(valueList);
        });

    } // printGenerateAndDisplayNumbers

    public static List<Integer> inputWinningNumber(String numbers){ // 사용자가 입력하는 당첨금액을 콤마를 제거한 숫자로만 만들기
        List<Integer> intNumbers = new ArrayList<>();

        while(true) {
            String[] strNumbers = numbers.split(",");
            boolean isValidInput = checkWinningNumberValidity(strNumbers, intNumbers);

            if(isValidInput){
                break;
            }

            numbers = readLine();
        }

        return intNumbers;
    } // inputWinningNumber

    public static boolean checkWinningNumberValidity(String[] strNumbers, List<Integer> intNumbers){ // 당첨번호 예외처리
        boolean isValidInput = true;

        for (String strNumber : strNumbers) {
            try {
                intNumbers.add(convertStringToInt(strNumber.trim()));
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
                isValidInput = false;
                break;
            }
        }

        return isValidInput;
    } // checkWinningNumberValidity

    public static List<Integer> inputWinningNumberVerification(List<Integer> inputWinningNumber){ // 사용자가 입력하는 당첨번호에 맞게 입력했는지 검증하는 메소드
        Lotto lotto = null;

        while(true) {
            try {
                lotto = new Lotto(inputWinningNumber);
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch(NullPointerException e){
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
            }

            String str = readLine();
            inputWinningNumber = inputWinningNumber(str);
        }

    } // inputWinningNumberVerification

    public static Integer inputBounsNumber(List<Integer> winnerNumber, String bonusNumber){ // 보너스 번호 입력
        while(true) {
            try {
                int bonusNum = convertStringToInt(bonusNumber);
                addBonusNumber(winnerNumber, bonusNum);
                return bonusNum;
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("[ERROR] 유효하지 않은 숫자입니다. 다시 시도하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            String str = readLine();
            bonusNumber = str;
        }
    } // inputBounsNumber

    public static void addBonusNumber(List<Integer> winnerNumber, int bonusNum){ // 입력한 보너스 번호를 검증하는 메소드
        if (!userInputNumber(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 1~45까지 중 에서 입력해주세요");
        }
        if (winnerNumber.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 이미 추가된 번호입니다. 다시 시도하세요.");
        }
    } // addBonusNumber

    public static boolean userInputNumber(Integer num){ // 당첨번호, 보너스 번호가 1 ~ 45만 입력했는지 검증 메소드

        if(num <= 0 || num > 45){
            return false;
        }
        return true;
    } // userInputNumber

    public static void printWinningStatistics(){ // 당첨 통계 UI
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+threeMatchPrize+"개");
        System.out.println("4개 일치 (50,000원) - "+fourMatchPrize+"개");
        System.out.println("5개 일치 (1,500,000원) - "+fiveMatchPrize+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+fiveMatchWithBonusPrize+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+sixMatchPrize+"개");
        System.out.println("총 수익률은 "+statistics+"%입니다.");
    } // printWinningStatistics

    public static Map<Integer, Integer> numberMatches(Map<Integer, List<Integer>> userCountRandomLotto, List<Integer> pickWinnerNumber){ // 각 랜덤 복권들과 당첨번호가 서로 몇개 맞는지 검증하는 메소드
        Map<Integer, Integer> countPerList = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : userCountRandomLotto.entrySet()) {
            int count = (int) entry.getValue().stream().filter(pickWinnerNumber::contains).count();
            countPerList.put(entry.getKey(), count);
        }

        return countPerList;
    } // numberMatches

    public static boolean containsBonusNumber(Map<Integer, List<Integer>> userCountRandomLotto, Integer bonusNumber){ // 보너스 번호가 랜덤으로 뽑힌 각 복권에 들어가 있는지 없는지 판별

        for(List<Integer> list : userCountRandomLotto.values()){
            if(list.contains(bonusNumber)){
                return true;
            }
        }
        return false;
    } // containsBonusNumber

    public static void determinePrizeRank(Map<Integer, List<Integer>> userCountRandomLotto, Map<Integer, Integer> matches, Integer bonusNumber){
        for(Integer value : matches.values()){
            if(value == PrizeCategory.MATCHES_SIX.getNumberOfMatches()){
                sixMatchPrize++;
            }
            if(value == PrizeCategory.MATCHES_FIVE_BONUS.getNumberOfMatches() && containsBonusNumber(userCountRandomLotto, bonusNumber)){
                fiveMatchWithBonusPrize++;
            }
            if(value == PrizeCategory.MATCHES_FIVE.getNumberOfMatches()){
                fiveMatchPrize++;
            }
            if(value == PrizeCategory.MATCHES_FOUR.getNumberOfMatches()){
                fourMatchPrize++;
            }
            if(value == PrizeCategory.MATCHES_THREE.getNumberOfMatches()){
                threeMatchPrize++;
            }
        }
    } // determinePrizeRank

    public static double calculateTotalProfitRate(){ // 매치되는 복권의 개수를 해당하는 항목과 계속하여 합하는 메소드
        return (sixMatchPrize * PrizeCategory.MATCHES_SIX.getPrizeAmount())
                + (fiveMatchWithBonusPrize * PrizeCategory.MATCHES_FIVE_BONUS.getPrizeAmount())
                + (fiveMatchPrize * PrizeCategory.MATCHES_FIVE.getPrizeAmount())
                + (fourMatchPrize * PrizeCategory.MATCHES_FOUR.getPrizeAmount())
                + (threeMatchPrize * PrizeCategory.MATCHES_THREE.getPrizeAmount());
    } // calculateTotalProfitRate

    public static void calculateProfitRate(int inputMoney){
        double prizeAvg = (calculateTotalProfitRate() / inputMoney) * 100.0;

        statistics = Math.round(prizeAvg * 100) / 100.0;
    } // calculateProfitRate


    // -- 테스트를 위한 Setter --

    public static void setSixMatchPrize(int sixMatchPrize) {
        Application.sixMatchPrize = sixMatchPrize;
    }

    public static void setFiveMatchWithBonusPrize(int fiveMatchWithBonusPrize) {
        Application.fiveMatchWithBonusPrize = fiveMatchWithBonusPrize;
    }

    public static void setFiveMatchPrize(int fiveMatchPrize) {
        Application.fiveMatchPrize = fiveMatchPrize;
    }

    public static void setFourMatchPrize(int fourMatchPrize) {
        Application.fourMatchPrize = fourMatchPrize;
    }

    public static void setThreeMatchPrize(int threeMatchPrize) {
        Application.threeMatchPrize = threeMatchPrize;
    }

    // -- 테스트를 위한 Getter --

    public static int getSixMatchPrize() {
        return sixMatchPrize;
    }

    public static int getFiveMatchWithBonusPrize() {
        return fiveMatchWithBonusPrize;
    }

    public static int getFiveMatchPrize() {
        return fiveMatchPrize;
    }

    public static int getFourMatchPrize() {
        return fourMatchPrize;
    }

    public static int getThreeMatchPrize() {
        return threeMatchPrize;
    }

    public static double getStatistics() {
        return statistics;
    }
}
