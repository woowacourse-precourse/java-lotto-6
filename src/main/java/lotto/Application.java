package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        int buyCount = lottoBuyCount(money);
        ArrayList<Lotto> list = buyLotto(buyCount);
        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbers = Console.readLine();

    }
    static int lottoBuyCount(String money){
        try{
            int lottoTotalCount = Integer.parseInt(money);
            if (lottoTotalCount % 1000 != 0){
                throw new IllegalArgumentException("구매 금액을 1000원 단위로 작성해주세요.");
            }
            return lottoTotalCount/1000;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력받은 값이 잘못되었습니다.");
        }
    }

    static ArrayList<Lotto> buyLotto(int buyCount){
        System.out.println(buyCount+"개를 구매했습니다.");
        ArrayList<Lotto> buyLottoNumbers = new ArrayList<>();
        for (int i=0;i<buyCount;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            buyLottoNumbers.add((new Lotto(numbers)));
        }
        return buyLottoNumbers;
    }

    static List<Integer> getWinningNumbers(String winNumbers){
        List<Integer> winningNumbers = new ArrayList<>();
        String[] getWinNumber = winNumbers.split(",");
        for (String number : getWinNumber){
            Integer winNumber = Integer.parseInt(number);
            winningNumbers.add(winNumber);
        }
        return winningNumbers;
    }
}
