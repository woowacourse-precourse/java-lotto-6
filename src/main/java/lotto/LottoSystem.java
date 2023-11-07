package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoSystem {
    private static final int PRICE_0 = 1000;
    private static final int PRICE_1 = 5000;
    private static final int PRICE_2 = 50000;
    private static final int PRICE_3 = 1500000;
    private static final int PRICE_4 = 3000000;
    private static final int PRICE_5 = 2000000000;
    private static final int PERCENT = 100;

    public void start() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        int lottoTicket = buyLottoTicket(Console.readLine());
        ArrayList<Lotto> buyLottoNumbers = buyLotto(lottoTicket);
        buyLottoNumbersPrint(buyLottoNumbers);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = getWinningNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(Console.readLine());
        int[] winLotto = lottoWinCheck(buyLottoNumbers, winningNumber, bonusNumber);
        winnerLottoNumbersPrint(lottoTicket, winLotto);
    }

    public int buyLottoTicket(String money) throws IllegalArgumentException {
        try{
            int parseMoney = Integer.parseInt(money);

            if (parseMoney % PRICE_0 != 0 || parseMoney == 0){
                throw new IllegalArgumentException(Message.Error.INVALID_MONEY_INPUT.getMessage());
            }
            return parseMoney/PRICE_0;
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
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

        if(getWinNumber.length != 6){
            throw new IllegalArgumentException(Message.Error.INVALID_WIN_NUMBER.getMessage());
        }
        for (String number : getWinNumber){
            try{
                Integer winNumber = Integer.parseInt(number);
                winningNumbers.add(winNumber);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
            }
        }
        winningNumbersOverlap(winningNumbers);
        return winningNumbers;
    }

    public void winningNumbersOverlap(List<Integer> winningNumbers){
        HashSet<Integer> overlapCheck = new HashSet<>(winningNumbers);
        if (overlapCheck.size() != winningNumbers.size()){
            throw new IllegalArgumentException(Message.Error.OVERLAP_INPUT.getMessage());
        }
    }

    public int getBonusNumber(String bonusNumber){
        try{
            return Integer.parseInt(bonusNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
        }
    }

    public int[] lottoWinCheck(ArrayList<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber){
        int[] winCheckNumber = new int[5];
        for(Lotto number : lottoNumbers){
            int equalNumbers = number.lottoNumbersContains(winningNumbers);
            int rank = lottoEqualNumber(equalNumbers, number, bonusNumber);
            if (rank != -1) {
                winCheckNumber[rank]++;
            }
        }
        return winCheckNumber;
    }

    public int lottoEqualNumber(int equalNumbers, Lotto lottoNumber, int bonusNumber){
        if (equalNumbers == 3){
            return 0;
        }
        if (equalNumbers == 4){
            return 1;
        }
        if (equalNumbers == 5){
            return lottoEqualBonusNumber(equalNumbers, lottoNumber, bonusNumber);
        }
        if (equalNumbers == 6){
            return 4;
        }
        return -1;
    }

    public int lottoEqualBonusNumber(int equalNumbers, Lotto lottoNumber, int bonusNumber){
        equalNumbers = lottoNumber.bonusNumberContains(equalNumbers, bonusNumber);
        if (equalNumbers == 6){
            return 3;
        }
        return 2;
    }

    public void winnerLottoNumbersPrint(int lottoTicket, int[] winLotto){
        double rateOfReturn = winningTotalMoney(winLotto)/(lottoTicket*PRICE_0)*PERCENT;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("3개 일치 (5,000원) - %d개", winLotto[0]));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", winLotto[1]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", winLotto[2]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", winLotto[3]));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", winLotto[4]));
        System.out.println(String.format("총 수익률은 %.1f",  rateOfReturn)+"%입니다.");
    }

    public double winningTotalMoney(int[] winLotto){
        double sum = 0;
        for(int i=0;i<winLotto.length;i++){
            sum += moneySum(i, winLotto[i]);
        }
        return sum;
    }

    public double moneySum(int rank, int lottoTickets){
        if (rank == 0){
            return lottoTickets * PRICE_1;
        }
        if (rank == 1){
            return lottoTickets * PRICE_2;
        }
        if (rank == 2){
            return lottoTickets * PRICE_3;
        }
        if (rank == 3){
            return lottoTickets * PRICE_4;
        }
        return lottoTickets * PRICE_5;
    }
}
