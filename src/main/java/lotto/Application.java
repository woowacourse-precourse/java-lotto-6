package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 최초 커밋 테스트
    }

    public static String inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        return inputPurchaseAmount;
    }

    public int inputPurchaseAmountValidation(String inputPurchaseAmount){
        try {
            int purchaseAmount = Integer.parseInt(inputPurchaseAmount);
            return purchaseAmount;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액을 숫자로 입력해 주세요. 예) 10000 ");
        }
    }

    public int lottoQuantity(int lottoPurchaseAmount){
        int lottoQuantity = lottoPurchaseAmount % 1000;
        if(lottoQuantity != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액을 1,000원 단위로 입력하세요.");
        }
        return lottoQuantity;
    }

    public List<Lotto> createLottos(int lottoQuantity){
        List<Lotto> lottos= new ArrayList<>();
        for(int quantity = 1; quantity <= lottoQuantity ; quantity++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

}
