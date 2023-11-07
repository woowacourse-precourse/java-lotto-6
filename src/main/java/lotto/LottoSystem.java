package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSystem {
    private static final int PRICE_0 = 1000;

    public void start() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoTicket = buyLottoTicket(Console.readLine());
        ArrayList<Lotto> buyLottoNumbers = buyLotto(lottoTicket);
        buyLottoNumbersPrint(buyLottoNumbers);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = getWinningNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(Console.readLine());
    }

    public int buyLottoTicket(String money) throws IllegalArgumentException {
        try{
            int parseMoney = Integer.parseInt(money);
            if (parseMoney % PRICE_0 != 0){
                throw new IllegalArgumentException("구매 금액을 1000원 단위로 작성해주세요.");
            }
            return parseMoney/PRICE_0;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력받은 값이 잘못되었습니다.");
        }
    }

    public void lottoNumberSort(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public ArrayList<Lotto> buyLotto(int buyCount){
        System.out.println(buyCount+"개를 구매했습니다.");
        ArrayList<Lotto> buyLottoNumbers = new ArrayList<>();
        for (int i=0;i<buyCount;i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumberSort(numbers);
            buyLottoNumbers.add((new Lotto(numbers)));
        }
        return buyLottoNumbers;
    }

    public void buyLottoNumbersPrint(ArrayList<Lotto> buyLottoNumbers){
        for (Lotto number : buyLottoNumbers){
            System.out.println(number.getLottoNumbers());
        }
    }

    public List<Integer> getWinningNumbers(String winNumbers){
        List<Integer> winningNumbers = new ArrayList<>();
        String[] getWinNumber = winNumbers.split(",");
        for (String number : getWinNumber){
            Integer winNumber = Integer.parseInt(number);
            winningNumbers.add(winNumber);
        }
        return winningNumbers;
    }

    public int getBonusNumber(String bonusNumber){
        try{
            return Integer.parseInt(bonusNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("입력받은 보너스의 값이 잘못되었습니다.");
        }
    }
}
