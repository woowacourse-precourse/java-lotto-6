package lotto.domain;

import static lotto.constant.Message.LOTTO_PRICE;
import static lotto.validation.LottoMachineValidation.validate_inputMoney;
import static lotto.validation.LottoMachineValidation.validate_winningLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.WinningRanking;
import lotto.dto.ResponseDto.LottoGameResultDto;

public class LottoMachine {

    private int inputAmount;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoMachine(){
        lottos = new ArrayList<>();
    }

    public List<Lotto> issuanceLotto(String inputAmount) {
        this.inputAmount = validate_inputMoney(inputAmount);
        while (this.inputAmount > 0){
            createLotto();
        }
        return lottos;
    }

    private void createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
        inputAmount -= LOTTO_PRICE;
    }

    public LottoGameResultDto createWinningLotto(String winningNums, String bonusNum){
        validate_winningLotto(winningNums, bonusNum);
        return transToWinningLotto(winningNums, bonusNum);
    }

    private LottoGameResultDto transToWinningLotto(String nums, String bonusNum){
        List<Integer> winningNums = Arrays.stream(nums.split(","))
            .map(Integer::parseInt).toList();
        this.winningLotto = new WinningLotto(winningNums, Integer.parseInt(bonusNum));
        return getResult(winningNums, Integer.parseInt(bonusNum));
    }

    public LottoGameResultDto getResult(List<Integer> nums, int bonusNum){
        int[] countWinning = getCountWinning(nums, bonusNum);
        double rateOfReturn = calculateRateOfReturn(countWinning);
        return new LottoGameResultDto(countWinning, rateOfReturn);
    }

    private int[] getCountWinning(List<Integer> nums, int bonusNum){
        int[] winningRankCnt = new int[WinningRanking.values().length + 1];
        for (Lotto lotto : lottos){
            int rank = lotto.getRank(nums, bonusNum);
            if(rank == -1){
                continue;
            }
            winningRankCnt[rank] += 1;
        }
        return winningRankCnt;
    }

    private double calculateRateOfReturn(int[] winningRankCnt){
        int totalAmount = 0;
        int rank = 1;
        for (WinningRanking winningRanking : WinningRanking.values()){
            totalAmount += winningRanking.getWinnings() * winningRankCnt[rank];
            rank += 1;
        }
        double rateOfReturn = (double) (totalAmount - inputAmount) / inputAmount * 100;
        rateOfReturn = (double) Math.round(rateOfReturn * 10) / 10;
        return rateOfReturn;
    }

}
