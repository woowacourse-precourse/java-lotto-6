package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


public class Application {
    static int purchaseLottoCost;



    static int validateInputCostIsNum(String inputCostStr){
        int inputCost = 0;
        try{
            inputCost = Integer.parseInt(inputCostStr);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }
        return inputCost;
    }

    static void validateInputCostByMod(int inputCost){
        if(inputCost%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 로또를 살 수 있습니다.");
        }
    }

    static void validateInputCostByLimit(int inputCost){
        if(inputCost<1000){
            throw new IllegalArgumentException("[ERROR] 로또를 사기 위한 최소 금액은 1,000원 입니다.");
        }
    }

    static int calculateLottoCount(String inputCostStr){
        int inputCost = validateInputCostIsNum(inputCostStr);

        validateInputCostByMod(inputCost);

        validateInputCostByLimit(inputCost);

        purchaseLottoCost = inputCost;

        return inputCost/1000;
    }



    static List<Integer> getLottoNumber(){
        List<Integer> LottoNumber = pickUniqueNumbersInRange(1, 45, 6);

        Collections.sort(LottoNumber);

        return LottoNumber;
    }


    static List<Lotto> generateLottos(int purchaseLottoCount){
        List<Lotto> generatedLottos = new ArrayList<>();

        for(int generatedLottoCount = 0; generatedLottoCount < purchaseLottoCount; generatedLottoCount++){
            Lotto generatedLotto = new Lotto(getLottoNumber());
            generatedLottos.add(generatedLotto);
        }

        return generatedLottos;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        int purchaseLottoCount = calculateLottoCount((sc.nextLine()));


        List<Lotto> purchasedLottos = generateLottos(purchaseLottoCount);



        sc.close();

    }
}
