package lotto.entity;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoGameDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {


    private Long id;
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private float rate;

    private Integer budget;

    private Integer amount;

    public LottoGame(String budget) throws IllegalArgumentException{
        Integer budgetInteger=validateBudget(budget);
        this.budget =budgetInteger;
        this.amount=setAmount(budgetInteger);
    }

    private Integer validateBudget(String budget) {
        Integer budgetInteger= validateInteger(budget);
        validateMinus(budgetInteger);
        validateThousand(budgetInteger);
        return budgetInteger;
    }

    private void validateThousand(Integer budget) {
        if(budget%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }

    private void validateMinus(Integer budget) {
        if(budget<1000){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000보다 작을 수 없습니다.");
        }
    }

    private Integer validateInteger(String budget) {
        try {
            return Integer.parseInt(String.valueOf(budget));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로 입력해주세요.");
        }
    }

    private Integer setAmount(Integer budget) {
        return budget/1000;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public LottoGameDto.Result doLottoGame() {
        int[] result = {0, 0, 0, 0, 0, 0, 0, 0};
        for (Lotto lotto : lottos) {
            int score = lotto.checkLottoScore(winningNumbers);
            if (score == 5 && lotto.checkLottoBonus(bonusNumber)) {
                score = 7;
            }
            result[score] += 1;
        }
        calculateRate(result);
        return new LottoGameDto.Result(result[3], result[4], result[5], result[7], result[6], rate);
    }

    private void calculateRate(int[] result) {
        int totalPrize = result[3] * Prize.THREE.getAmount() + result[4] * Prize.FOUR.getAmount() + result[5] * Prize.FIVE.getAmount() + result[7] * Prize.FIVEANDBONUS.getAmount() + result[6] * Prize.SIX.getAmount();
        rate = (float) totalPrize / (float) budget;
        rate *= 100;
        rate= (float) Math.round(rate*10)/10.0f;
    }

    public List<List<Integer>> createLotto() {
        List<List<Integer>> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber =Randoms.pickUniqueNumbersInRange(1, 45, 6);

            lottoNumberList.add(lottoNumber);
            Lotto lotto = new Lotto(lottoNumber);
            lottos.add(lotto);
        }
        return lottoNumberList;
    }

    public void setWinningNumbers(List<Integer> winningNumbers,Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
