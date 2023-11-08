package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import javax.print.DocFlavor;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoSystem {
    private static final int PERCENT = 100;
    private static final int EQUAL_3 = 3;
    private static final int EQUAL_4 = 4;
    private static final int EQUAL_5 = 5;
    private static final int EQUAL_6 = 6;
    private static final int NOT_EQUAL = -1;
    private static final int RANK = 5;


    private final LottoUI lottoUI;
    public LottoSystem(){
        this.lottoUI = new LottoUI();
    }
    public void start() throws IllegalArgumentException {
        lottoUI.userPrint(LottoUI.PrintMessage.INPUT_MONEY.getMessage());
        int lottoTicket = buyLottoTicket(lottoUI.userInput());
        ArrayList<Lotto> buyLottoNumbers = buyLotto(lottoTicket);
        lottoUI.buyLottoNumbersPrint(buyLottoNumbers);

        lottoUI.userPrint(LottoUI.PrintMessage.INPUT_WIN_NUMBER.getMessage());
        Lotto winningNumber = getWinningNumbers(lottoUI.userInput());

        lottoUI.userPrint(LottoUI.PrintMessage.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = getBonusNumber(lottoUI.userInput());
        bonusNumberOverlap(winningNumber.getLottoNumbers(), bonusNumber);
        int[] winLotto = lottoWinCheck(buyLottoNumbers, winningNumber.getLottoNumbers(), bonusNumber);
        winnerLottoNumbersPrint(lottoTicket, winLotto);
    }

    public int buyLottoTicket(String money) throws IllegalArgumentException {
        try{
            int parseMoney = Integer.parseInt(money);

            if (parseMoney % LottoValue.PRICE.BUY_PRICE.getPrice() != 0 || parseMoney == 0){
                throw new IllegalArgumentException(Message.Error.INVALID_MONEY_INPUT.getMessage());
            }
            return parseMoney/LottoValue.PRICE.BUY_PRICE.getPrice();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
        }
    }

    public void lottoNumberSort(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public ArrayList<Lotto> buyLotto(int buyCount){
        lottoUI.buyLottoCountPrint(buyCount);
        ArrayList<Lotto> buyLottoNumbers = new ArrayList<>();
        for (int i=0;i<buyCount;i++){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumberSort(numbers);
            buyLottoNumbers.add((new Lotto(numbers)));
        }
        return buyLottoNumbers;
    }

    public Lotto getWinningNumbers(String winNumbers){
        List<Integer> winningNumbers = new ArrayList<>();
        String[] getWinNumber = winNumbers.split(",");
        for (String number : getWinNumber){
            try{
                Integer winNumber = Integer.parseInt(number);
                winningNumbers.add(winNumber);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
            }
        }
        return new Lotto(winningNumbers);
    }

    public int getBonusNumber(String bonusNumber){
        try{
            int number = Integer.parseInt(bonusNumber);
            bonusNumberInRange(number);
            return number;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT.getMessage());
        }
    }

    public void bonusNumberInRange(int number){
        if (number < LottoValue.Value.MIN.getValue()){
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT_MIN.getMessage());
        }
        if (number > LottoValue.Value.MAX.getValue()){
            throw new IllegalArgumentException(Message.Error.INVALID_INPUT_MAX.getMessage());
        }
    }

    public void bonusNumberOverlap(List<Integer> winningNumbers, int bonusNumber){
        HashSet<Integer> overlapCheck = new HashSet<>(winningNumbers);
        int before = overlapCheck.size();
        overlapCheck.add(bonusNumber);
        if (before == overlapCheck.size()){
            throw new IllegalArgumentException(Message.Error.OVERLAP_INPUT.getMessage());
        }
    }

    public int[] lottoWinCheck(ArrayList<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber){
        int[] winCheckNumber = new int[RANK];
        for(Lotto number : lottoNumbers){
            int equalNumbers = number.lottoNumbersContains(winningNumbers);
            int rank = lottoEqualNumber(equalNumbers, number, bonusNumber);
            if (rank != NOT_EQUAL) {
                winCheckNumber[rank]++;
            }
        }
        return winCheckNumber;
    }

    public int lottoEqualNumber(int equalNumbers, Lotto lottoNumber, int bonusNumber){
        if (equalNumbers == EQUAL_3){
            return LottoValue.Reward.REWARD_5.getPrice();
        }
        if (equalNumbers == EQUAL_4){
            return LottoValue.Reward.REWARD_4.getPrice();
        }
        if (equalNumbers == EQUAL_5){
            return lottoEqualBonusNumber(equalNumbers, lottoNumber, bonusNumber);
        }
        if (equalNumbers == EQUAL_6){
            return LottoValue.Reward.REWARD_1.getPrice();
        }
        return NOT_EQUAL;
    }

    public int lottoEqualBonusNumber(int equalNumbers, Lotto lottoNumber, int bonusNumber){
        equalNumbers = lottoNumber.bonusNumberContains(equalNumbers, bonusNumber);
        if (equalNumbers == EQUAL_6){
            return LottoValue.Reward.REWARD_2.getPrice();
        }
        return LottoValue.Reward.REWARD_3.getPrice();
    }

    public void winnerLottoNumbersPrint(int lottoTicket, int[] winLotto){
        double rateOfReturn = winningTotalMoney(winLotto)/(lottoTicket*LottoValue.PRICE.BUY_PRICE.getPrice())*PERCENT;
        lottoUI.winnerLottoNumberPrint(winLotto, rateOfReturn);
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
            return lottoTickets * LottoValue.PRICE.PRICE_5.getPrice();
        }
        if (rank == 1){
            return lottoTickets * LottoValue.PRICE.PRICE_4.getPrice();
        }
        if (rank == 2){
            return lottoTickets * LottoValue.PRICE.PRICE_3.getPrice();
        }
        if (rank == 3){
            return lottoTickets * LottoValue.PRICE.PRICE_2.getPrice();
        }
        return lottoTickets * LottoValue.PRICE.PRICE_1.getPrice();
    }
}
