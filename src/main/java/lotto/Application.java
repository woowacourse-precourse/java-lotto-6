package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int purchaseAmount = getValidPurchaseAmount();
        int lottoAmount = getLottoAmount(purchaseAmount);
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");

        List<Lotto> lottoTickets = generateLottoTickets(lottoAmount);
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }

        List<Integer> winnigNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winnigNumbers);
    }

    public static int getValidPurchaseAmount(){
        int purchaseAmount = 0;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            try{
                purchaseAmount = sc.nextInt();
                sc.nextLine();
                if(isGoodPurchaseAmount(purchaseAmount)){
                    break;
                }
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
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

    private static List<Lotto> generateLottoTickets(int lottoAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoTickets;
    }

    public static List<Integer> getWinningNumbers(){
        List<Integer> winnigNumbers = new ArrayList<>();
        while(true){
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try{
                String[] input = sc.nextLine().split(",");
                if(isGoodWinningNumbers(input)){
                    for(String numberStr: input){
                        winnigNumbers.add(Integer.parseInt(numberStr));
                    }
                    break;
                }
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return winnigNumbers;
    }

    public static boolean isGoodWinningNumbers(String[] input){
        if(input.length != 6) return false;

        HashSet<Integer> set = new HashSet<>();
        for(String numberStr: input){
            int number = Integer.parseInt(numberStr);
            if(number < 1 || number > 45 || !set.add(number)){
                return false;
            }
        }
        return true;
    }

    public static int getBonusNumber(List<Integer> winnigNumbers){
        int bonusNumber = 0;
        while(true){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            try{
                bonusNumber = sc.nextInt();
                if(isGoodBonusNumber(bonusNumber, winnigNumbers)){
                    break;
                }
                throw new IllegalArgumentException("[ERROR] 로또 번호와 중복되지 않는 번호이고, 1부터 45 사이의 숫자여야 합니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public static boolean isGoodBonusNumber(int bonusNumber, List<Integer> winnigNumbers){
        if(bonusNumber < 1 || bonusNumber > 45) return false;
        for(int i=0; i<winnigNumbers.size(); i++){
            if(bonusNumber == winnigNumbers.get(i)) return false;
        }
        return true;
    }
}