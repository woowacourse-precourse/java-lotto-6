package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.LottoConstants;

public class PurchaseAmount {
     int PURCHASEPRICE = LottoConstants.PURCHASE_PRICE.getValue();
     int PurchaseCount;

     public PurchaseAmount(){
         String purchseAmount = Console.readLine();
         int inputPrice = canParse(purchseAmount);
         PurchaseAmountValidate(inputPrice);
         PurchaseCount = calculatePurchaseLottoCount(inputPrice);
     }
     public int canParse(String purchseAmount){
         try{
             Integer.parseInt(purchseAmount);
         }catch(Exception e){
             System.out.println("구매 금액은 숫자형으로 입력해주세요");
             purchseAmount = Console.readLine();
         }
         return Integer.parseInt(purchseAmount);
     }

     public void PurchaseAmountValidate(int inputPrice){
         try{
             IsInputPriceDividedPurchasePrice(inputPrice);
         }catch (IllegalArgumentException e){
             System.out.println("1000단위로 구매 금액을 입력해주세요 ");
             inputPrice = Integer.parseInt(Console.readLine());
         }

         try {
             IsNotZero(inputPrice);
         }catch (IllegalArgumentException e){
             System.out.println("구매 금액은 0이 아닌 금액을 입력해주세요.");
             inputPrice = Integer.parseInt(Console.readLine());
         }
    }

    public boolean IsInputPriceDividedPurchasePrice(int inputPrice) throws IllegalArgumentException{
        if(inputPrice % PURCHASEPRICE != 0){
            throw new IllegalArgumentException();
            }

        return true;
    }
    public boolean IsNotZero(int inputPrice) throws IllegalArgumentException{
        if(inputPrice == 0){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int calculatePurchaseLottoCount(int inputPrice){
         return (inputPrice % PURCHASEPRICE);
    }
}
