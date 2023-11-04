package lotto;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount / 1000);

        Lotto winningLotto = new Lotto(inputWinningNumbers());
        int bonusNumber = inputBonusNumber();

    }
    // 입력받고 로또 생성
    private static int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        validPurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }
    private static void validPurchaseAmount(int amount){
        if(amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int count){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i<count; i++){
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }
    private static List<Integer> generateRandomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    // 당첨 로또 생성
    private static List<Integer> inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numberStrings = input.split(",");
        List<Integer> winningNumbers = Arrays.stream(numberStrings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private static int inputBonusNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        int bonusNumber =  Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

    // 결과 계산
    private static Map<String, Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber){
        Map<String, Integer> resultMap = new HashMap<>();

        for(Lotto lotto : lottos){
            int matchCount = winningLotto.countMatchedNumbers(lotto);

            if(matchCount<3)continue;

            boolean bonusMatch = winningLotto.isBonusMatched(bonusNumber);
            String key = getKey(matchCount, bonusMatch);

            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }
        return resultMap;
    }
    
    private static String getKey(int matchCount, boolean bonusMatch){
        // 추가로 작성
        
        return matchCount + "개 일치";
    }
}
