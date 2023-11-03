package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchase = 0; // 구입 금액
        while(true){
            try{
                purchase = inputPurchase();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }

        }

        // 2-1. 구입한 금액만큼 로또 번호 생성
        int count = purchase / 1000; // 생성할 로또 수량
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<count; i++){
            Lotto lotto = new Lotto(createRandomLottoNum());
            lottoList.add(lotto);
        }

        // 2-2. 발행한 로또 수량 출력
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        // 2-3. 발행한 로또 번호를 출력 (오름차순으로)
        for(Lotto lotto : lottoList){
            printLottoInfo(lotto);
        }

        // 3. 당험 번호 입력받기
        List<Integer> winningNumbers;
        while(true){
            try{
                winningNumbers = inputWinningNumbers();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }
        Lotto winningLotto = new Lotto(winningNumbers);

    }


    // 1-1. 로또 금액 입력 받음
    public static int inputPurchase(){
        int purchase = 0;
        System.out.println("구입금액을 입력해 주세요.");
        purchase = Integer.parseInt(Console.readLine());
        if(purchase % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
        return purchase;
    }

    // 2. 당험 번호 입력받기
    public static List<Integer> inputWinningNumbers(){
        // 3-1. 당첨 번호를 입력받음
        // 3-2. 입력받은 당첨 번호를 쉼표(,) 기준으로 구분함
        String[] inputNumbers = Console.readLine().split(",");
        List<Integer> winningNumbers = parseInputNumbers(inputNumbers); // 사용자 입력을 List<Integer>로 변환

        // 3-3, 3-4, 3-5. 당첨 번호 유효성 검사
        if(!validateSize(winningNumbers)){
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
        if(!validateDuplicates(winningNumbers)){
            throw new IllegalArgumentException("로또 번호는 중복된 숫자가 없어야 합니다.");
        }
        if(!validateNumberRange(winningNumbers)){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return winningNumbers;
    }

    // 로또 번호 생성
    public static List<Integer> createRandomLottoNum(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    // 발행한 로또 수향 및 번호를 출력
    public static void printLottoInfo(Lotto lotto){
        Collections.sort(lotto.lottoNumbers());
        System.out.println(lotto.lottoNumbers());
    }

    // 사용자 입력을 List<Integer>로 변환
    public static List<Integer> parseInputNumbers(String[] inputNumbers){
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<inputNumbers.length; i++){
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
        return numbers;
    }

    // 3-3. 로또 번호의 개수가 6개가 넘어가면 예외 발생
    public static boolean validateSize(List<Integer> inputNumbers){
        boolean validate = true;
        if(inputNumbers.size() != 6){
            validate = false;
        }
        return validate;
    }

    // 3-4. 로또 번호에 중복된 숫자가 있으면 예외 발생
    public static boolean validateDuplicates(List<Integer> inputNumbers){
        boolean validate = true;
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int number : inputNumbers){
            if(uniqueNumbers.contains(number)){
                validate = false;
            }
            uniqueNumbers.add(number);
        }
        return validate;
    }

    // 3-5. 번호의 범위가 1~45가 아닐 경우 예외 발생
    public static boolean validateNumberRange(List<Integer> inputNumbers){
        boolean validate = true;
        for(int number : inputNumbers){
            if(number < 1 || number > 45){
                validate = false;
            }
        }
        return validate;
    }
}
