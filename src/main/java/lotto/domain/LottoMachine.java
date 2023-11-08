package lotto.domain;

import static lotto.constant.Message.LOTTO_PRICE;
import static lotto.validation.LottoMachineValidation.validate_inputMoney;
import static lotto.validation.LottoMachineValidation.validate_winningLotto;
import static lotto.validation.LottoValidation.validate_lottoNum;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<List<Integer>> issuanceLotto(String inputAmount) {
        this.inputAmount = validate_inputMoney(inputAmount);
        List<List<Integer>> issuedLottos = new ArrayList<>();
        while (this.inputAmount > 0){
            issuedLottos.add(createLotto());
        }
        return issuedLottos;
    }

    private List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        ascendingNumbers(numbers);
        Lotto lotto = new Lotto(numbers);
        lottos.add(lotto);
        inputAmount -= LOTTO_PRICE;
        return numbers;
    }

    private void ascendingNumbers(List<Integer> numbers) {
        List<Integer> nums = new ArrayList<Integer>(numbers);
        Collections.sort(nums);
    }

    public LottoGameResultDto createWinningLotto(String winningNums, String bonusNum){
        validate_winningLotto(winningNums, bonusNum);
        return transToWinningLotto(winningNums, bonusNum);
    }

    private LottoGameResultDto transToWinningLotto(String nums, String bonusNum){
        List<Integer> winningNums = Arrays.stream(nums.split(","))
            .map(Integer::parseInt).toList();
        int bonus = Integer.parseInt(bonusNum);
        this.winningLotto = new WinningLotto(winningNums, bonus);
        return getResult(winningNums, bonus);
    }

    private void validateWinningLottoNum(List<Integer> winningNums, int bonus) {
        List<Integer> winningNumsPlusBonus = new ArrayList<>(winningNums);
        winningNumsPlusBonus.add(bonus);
        validate_lottoNum(winningNumsPlusBonus);
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
        double totalAmount = 0;
        int rank = 1;
        for (WinningRanking winningRanking : WinningRanking.values()){
            totalAmount += (winningRanking.getWinnings() * winningRankCnt[rank]);
            rank += 1;
        }
        int investMoney = LOTTO_PRICE * lottos.size();
        double earn = totalAmount - investMoney;
        if(earn < 1){
            return 0;
        }

        return (earn * 100 / investMoney);
    }

}
