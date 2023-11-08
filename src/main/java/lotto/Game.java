package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

class Game{
    public static final String HOW_MUCH_BUYING_TEXT = "구입금액을 입력해 주세요.";
    public static final String BOUGHT_LOTTO_TEXT = "개를 구매했습니다.";
    public static final String YOUR_CALL_NUMS_TEXT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_TEXT = "보너스 번호를 입력해 주세요.";
    public static final String CORRECT_STATISTIC = "당첨 통계\n---";
    public static final String FIFTH_PLACE = "3개 일치 (5,000원) - ";
    public static final String FOURTH_PLACE = "4개 일치 (50,000원) - ";
    public static final String THIRD_PLACE = "5개 일치 (1,500,000원) - ";
    public static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - ";


    public void startGame(){
        int userMoneyInput = getUserMoneyInput();
        List<Lotto> lottos = makeLotto(userMoneyInput);
        List<Integer> userNumInput = getUserNumsInput();
        int bonus = getUserBonusNumInput();
        int[] correctPlace = compareLottos(lottos,userNumInput,bonus);
        judgeProfit(correctPlace,userMoneyInput);
    }

    private int getUserMoneyInput() {
        int input = 0;
        boolean validInput = false;
        do {
            try {
                System.out.println(HOW_MUCH_BUYING_TEXT);
                input = Integer.parseInt(Console.readLine());
                validInput = validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위로 금액을 입력하세요.");
            }
        } while (!validInput);
        return input;
    }
    private boolean validate(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private List<Lotto> makeLotto(int userMoneyInput) {
        System.out.println(String.valueOf(userMoneyInput/1000)+BOUGHT_LOTTO_TEXT);
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<userMoneyInput/1000; i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            System.out.println(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        System.out.println();
        return lottos;
    }


    private List<Integer> getUserNumsInput() {
        boolean validNum;
        List<Integer> numbersList = null;
        do {
            validNum = true;
            try {
                System.out.println(YOUR_CALL_NUMS_TEXT);
                String numbersString = Console.readLine();
                numbersList = Arrays.stream(numbersString.split(",")).map(Integer::parseInt).toList();
                validate(numbersList);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 6개의 숫자를 입력해주세요.");
                validNum = false;
            } catch (IllegalStateException e) {
                System.out.println("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
                validNum = false;
            }
        } while (!validNum);
        System.out.println();
        return numbersList;
    }

    private void validate(List<Integer> numbersList) {
        if (numbersList.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numberSet = new HashSet<>(numbersList);
        if (numbersList.size() != numberSet.size()) {
            throw new IllegalStateException();
        }
    }

    private int getUserBonusNumInput() {
        System.out.println(BONUS_NUM_TEXT);
        String bonus = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonus);
    }

    private int[] compareLottos(List<Lotto> lottos, List<Integer> userNumInput, int bonus) {
        int[] correctPlace = {0,0,0,0,0};
        for (Lotto L : lottos) {
            int place = compareNums(L.getNumbers(),userNumInput);
            if (place == 5 && bonusJuge(L.getNumbers(),bonus)){ //5개 일치, 보너스 볼 일치
                correctPlace[3] +=1;
                continue;
            }
            if (place == 6) {
                correctPlace[4] +=1;
                continue;
            }
            if (place >=3){
                correctPlace[place-3] +=1;
            }
        }
        printBoard(correctPlace);
        return correctPlace;
    }

    private boolean bonusJuge(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)){
            return true;
        }
        return false;
    }

    private int compareNums(List<Integer> numbers, List<Integer> userNumInput) {
        int count = 0;
        for (int i : numbers) {
            if (userNumInput.contains(i)){
                count+=1;
            }
        }
        return count;
    }
    private void printBoard(int[] correctPlace) {
        System.out.println(CORRECT_STATISTIC);
        System.out.println(FIFTH_PLACE+String.valueOf(correctPlace[0])+"개");
        System.out.println(FOURTH_PLACE+String.valueOf(correctPlace[1])+"개");
        System.out.println(THIRD_PLACE+String.valueOf(correctPlace[2])+"개");
        System.out.println(SECOND_PLACE+String.valueOf(correctPlace[3])+"개");
        System.out.println(FIRST_PLACE+String.valueOf(correctPlace[4])+"개");
    }


    private void judgeProfit(int[] correctPlace,int userMoneyInput) {
        int[] profit = {5000,50000,1500000,30000000,2000000000};
        long total = 0;
        for (int i=0; i<profit.length; i++){
            total += (long) profit[i] * correctPlace[i];
        }
        double roundedNum = Math.round((total/(double)userMoneyInput)*1000.0) /10.0 ;
        System.out.println("총 수익률은 "+String.valueOf(roundedNum)+"%입니다.");
    }
}