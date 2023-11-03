package lotto;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.MAX_LOTTO_COUNT;
import static lotto.config.RuleConfig.MAX_LOTTO_NUM;
import static lotto.config.RuleConfig.MIN_LOTTO_NUM;
import static lotto.config.RuleConfig.NUMBERS_PER_LOTTO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private List<Lotto> lottos;
    private int trial;
    private LottoGenerator(String money){
        trial = Integer.parseInt(money) / BASE_LOTTO_PRICE;
        this.lottos = new ArrayList<>();
    }
    public static LottoGenerator createLottoGenerator(String money){
        validateMoney(money);
        return new LottoGenerator(money);
    }
    public int getTrial(){
        return this.trial;
    }
    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public void generateLottos(){
        for(int i = 0; i < trial; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, NUMBERS_PER_LOTTO);
            List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
            Lotto newLotto = new Lotto(sortedNumbers);
            lottos.add(newLotto);
        }
    }

    public static void validateMoney(String money){
        int parsedMoney;
        try{
            parsedMoney = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalStateException(ErrorMessages.NOT_INTEGER.toString());
        }
        if(parsedMoney <= 0){
            throw new IllegalStateException(ErrorMessages.NO_MONEY.toString());
        }
        if(parsedMoney > MAX_LOTTO_COUNT * BASE_LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessages.TOO_MANY_LOTTOS.toString());
        }
        if(parsedMoney % 1000 > 0){
            throw new IllegalArgumentException(ErrorMessages.UNIT_BASE_PRICE.toString());
        }
    }
}
