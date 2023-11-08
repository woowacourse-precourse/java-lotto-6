package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Input {
   public Integer InputAmount(){
       System.out.println("구입금액을 입력해 주세요.");
       String strInput = readLine();
       Integer amount = Integer.parseInt(strInput);

       return amount;
   }

   public void AmountValidate(Integer Amount) throws IllegalArgumentException{
       //1000원 단위로 입력
       Integer remainValue = Amount%1000;
       if(remainValue!=0) {
           throw new IllegalArgumentException();
       }
   }

   public Integer CheckNumberofLotto(Integer Amount){
       int NumberofLotto = Amount/1000;

       return NumberofLotto;
   }

   public Integer readAmount(){
       Input input = new Input();
       Integer amount;
       while(true){
           try {
               amount = input.InputAmount();
               input.AmountValidate(amount);
               break;
           }catch(IllegalArgumentException e){
               System.out.println("[ERROR] 1000단위로 재입력하세요!");
           }
       }


       Integer NumberofLotto = input.CheckNumberofLotto(amount);
       return NumberofLotto;
   }

    public ArrayList<Integer> IssueLotto(){
        ArrayList<Integer> Lotto = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        tmp = pickUniqueNumbersInRange(1,45,6);
        Lotto.addAll(tmp);

        return Lotto;
    }

    public ArrayList<Integer> InputLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String strInput = readLine();
        String[] strArr = strInput.split(",");
        Integer[] integerArr = Stream.of(strArr).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        ArrayList<Integer> Lotto = new ArrayList<>();
        for(int i=0; i<integerArr.length; i++){
            Lotto.add(integerArr[i]);
        }

        return Lotto;
    }

    public ArrayList<Integer> readLotto(){
       Input input = new Input();
        ArrayList<Integer> numbers = new ArrayList<>();
       while(true){
           try{
               numbers = input.InputLotto();
//               input.LottoValidate(lotto);
               Lotto lotto = new Lotto(numbers);
               break;
           }
           catch(IllegalArgumentException e){
               System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다, 중복값이 없어야 합니다, 6개의 숫자로 이루어져야 합니다.");
           }
       }

       return numbers;
    }

    public Integer readBonous(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String strInput = readLine();
        Integer BonousNumber = Integer.parseInt(strInput);

        return BonousNumber;
    }
}
