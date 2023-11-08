package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Application {
    public static final int minLOTTOPRICE = 1000; //최소 구매가격
    public static final int minLOTTOCOUNT = 6; //적정 로또 갯수
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputMoney(); //로또 구매 횟수 입력

        List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount); //로또 구매
        showLotto(purchasedLottos); //로또 출력
        List<Integer> winningNumber = inputWinningNumbers(); //정답로또 입력
        int bonusNumber = inputBonus(); //정답 보너스 입력
        WinningResult winningResult = calculateResults(purchasedLottos,winningNumber,bonusNumber); //정답체킹
        winningResult.printResult(purchaseAmount); //정답 출력
    }
    private static int inputMoney(){ //구매 입력 함수
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
            if(money <=0 || money % minLOTTOPRICE!=0) {
                throw new IllegalArgumentException("[ERROR]구입 금액은 1000원 이상이어야 합니다.");
            }
            return money/minLOTTOPRICE;
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("[ERROR]유효하지 않은 값 입니다.");
        }
    }

    private static List<Lotto> purchaseLottos(int buyAmount) { //로또 구매 입력받아 랜덤함수로 넘김
        List<Lotto> lottos = new ArrayList<>();
        System.out.println(buyAmount+"개를 구매했습니다");
        for(int i=0;i<buyAmount;i++){
            lottos.add(randomLotto());
        }
        return lottos;
    }

    private static Lotto randomLotto(){ //로또 랜덤으로 숫자를 생성해 리스트(set)에 전달
        Set<Integer> randomSet = new HashSet<>();
        while (randomSet.size()<minLOTTOCOUNT){
            int randomNumber = Randoms.pickNumberInRange(1,45);
            randomSet.add(randomNumber);
        }
        return new Lotto(new ArrayList<>(randomSet));
    }

    private static void showLotto(List<Lotto> purchedLottos) { //구매 횟수만큼 랜덤로또 출력
        for(Lotto lotto : purchedLottos){
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer>inputWinningNumbers(){ //당첨번호 입력받아 저장하는 함수
        System.out.println("당첨번호를 입력해주세요 : ");
        List<Integer> winningNum = new ArrayList<>();
        String[] inputNumbers = Console.readLine().split(",");
        for(String numStr : inputNumbers) {
            winningNum.add(Integer.parseInt(numStr.trim()));
        }
        return winningNum;
    }

    private static int inputBonus() { //보너스번호 입력받는 함수
        System.out.println("보너스번호를 입력해주세요 : ");
        return Integer.parseInt(Console.readLine().trim());
    }

    private static WinningResult calculateResults (List<Lotto> purchasedLottos,List<Integer> winningNumbers, int bonusNumber){
        WinningResult winningResult = new WinningResult(); //승리 계산 함수, 랜덤으로 생성한 로또번호와 입력한 로또정답을 서로 비교
        for (Lotto lotto : purchasedLottos){
            int matchcount = lotto.countMatch(winningNumbers);
            boolean bonusMatch = lotto.bonusMatch(bonusNumber); //보너스가 맞을 경우 참, 틀릴경우 거짓으로 전달
            winningResult.addResult(matchcount,bonusMatch);
        }
        return winningResult;
    }
}
