package lotto;

import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int purchaseAmount = getValidPurchaseAmount();
        int lottoAmount = getLottoAmount(purchaseAmount);
    }

    public static int getValidPurchaseAmount(){
        int purchaseAmount = 0;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                purchaseAmount = sc.nextInt();
                if(isGoodPurchaseAmount(purchaseAmount)){
                    break;
                }
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            }
        }
        return purchaseAmount;
    }

    public static boolean isGoodPurchaseAmount(int purchaseAmount){
        return purchaseAmount % 1000 == 0;
    }

    public static int getLottoAmount(int purchaseAmount){
        return purchaseAmount / 1000;
    }
}
