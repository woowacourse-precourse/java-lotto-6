package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //로또 구입 금액 입력받기
        int purchaseAmount=getPurchaseAmount();


    }
    //로또 구입 금액 입력받기, 1000원 단위로 입력받음, 1000원으로 나누어 떨어지지 않으면 예외
    private static int getPurchaseAmount() {
        int purchaseAmount;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                purchaseAmount = Integer.parseInt(Console.readLine());
                if(purchaseAmount%1000!=0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;

    }
    //당첨 번호 입력 받기
    private static List<Integer> getWinningNumbers() {
        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            try{
                String input=Console.readLine();
                List<Integer> numbers=parseCommaSeperatedNumbers(input);
                if (numbers.size() !=6){
                    throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해주세요.");
                }
                return numbers;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private  static int getBonusNumber() {
        while(true){
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                int bonusNumber=Integer.parseInt(Console.readLine());
                if (bonusNumber<1 || bonusNumber>45){
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private static List<Lotto> generateLotto(int purchaseAmount) {
        int numberOfLottos=purchaseAmount/1000;
        List<Lotto> lottos=new ArrayList<>();

        for(int i=0;i<numberOfLottos; i++){
            List<Integer> numbers=generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        System.out.println(numberOfLottos+"개 를 구매했습니다.");
        return lottos;
    }
    private  static  List<Integer> generateLottoNumbers(){
        List<Integer> numbers=new ArrayList<>();
        while (numbers.size()<6) {
            int randomNumber=Randoms.pickNumberInRange(1,45);
            //중복된 숫자가 담기지 않도록
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        numbers.sort(Integer::compareTo);
        return numbers;
    }


    private static List<Integer> parseCommaSeperatedNumbers(String input){
        String[] tokens=input.split(",");
        //일단 테스트 해보고 수정
        try{
            return Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 잘못된 번호 형식입니다.");
        }
    }

    //보너스 입력 받기

}
