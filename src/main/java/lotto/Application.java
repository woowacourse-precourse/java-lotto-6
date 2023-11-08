package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static final int PRICE = 1000;
    static int purchasePrice;
    static boolean isRightRange = true;
    static ArrayList<List<Integer>> lottos = new ArrayList<>();
    static String [] inputNumbers;
    static int BonusNumber;
    static List<Integer> winningNumbers = new ArrayList<>();

    public static void printLottoNumbers(int ticketAmount, ArrayList<List<Integer>> lottos){
        System.out.println("\n" + ticketAmount + "개를 구매했습니다.");
        for (int i = 0; i < ticketAmount; i++) {
            System.out.println(lottos.get(i));
        }
    }
    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        purchasePrice = Integer.parseInt(Console.readLine());
        return purchasePrice;
    }
    public static int getLotteryTickets(int money, int PRICE){
        int amount = money / PRICE;
        return amount;
    }

    public static void checkValidatePrice(int money,int PRICE){
        try {
            if (money % PRICE != 0)
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 구매금액이 나누어 떨어지지 않습니다.");
        }
    }
    public static void getInput(){
        System.out.println("\n당첨 번호를 입력해주세요.");
        inputNumbers = Console.readLine().split(",");
    }

    private static void validateNumber(String[] input){
        if(input.length != 6)
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아님");
    }
    public static void getBonusNumber(){
        System.out.println("\n보너스 번호를 입력해주세요.");
        BonusNumber = Integer.parseInt(Console.readLine());
    }
    public static List<Integer> input2WinnigNumber(String[] inputNumbers){
        for (String number : inputNumbers) {
            int num = Integer.parseInt(number);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }
    static boolean validateRange(){
        for (int num : winningNumbers ) {
            if(num < 1 && num > 45)
                isRightRange = false;
        }
        return isRightRange;
    }
    private static boolean checkOverlappedNumber(){
        boolean overlapExist = false;
        for (int i = 0; i < winningNumbers.size(); i++) {
            int overlapTime = Collections.frequency(winningNumbers,winningNumbers.get(i));
            if (overlapTime != 0)
                overlapExist = true;
        }
        return overlapExist;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구입 금액 입력 받기
        int ticketAmount = getLotteryTickets(getMoney(),PRICE);
        checkValidatePrice(purchasePrice,PRICE);

        //로또 생성
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
        //  로또 출력
        printLottoNumbers(ticketAmount,lottos);

        // 당첨 번호 입력 받기 : 쉼표 기준으로 구분
        getInput();
        // 보너스 번호 입력
        getBonusNumber();

        //  당첨 번호가 1 ~ 45인지 확인
        input2WinnigNumber(inputNumbers);
        validateRange();
        //  당첨 번호 중 중복 값이 있는지 확인
        checkOverlappedNumber();;

        /*
        try{
        }catch(PatternSyntaxException e) {
        }
        */
    }
}
