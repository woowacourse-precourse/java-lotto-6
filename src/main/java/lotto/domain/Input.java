package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
               System.out.println("[Error] 1000단위로 재입력하세요!");
           }
       }


       Integer NumberofLotto = input.CheckNumberofLotto(amount);
       return NumberofLotto;
   }

}
