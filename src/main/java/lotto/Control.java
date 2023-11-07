package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
public class Control {
    static int inputMoney = 0;              // 사용자가 입력한 구입금액
    static int count = 0;                   // 구입금액으로 구입 가능한 로또 개수
    static List<Integer> correctNumber;     // 로또 당첨 번호
    static int bonusNumber = 0;             // 사용자가 입력한 보너스 번호
    static int threeCorrect = 0;            // 3개 번호 일치
    static int fourCorrect = 0;             // 4개 번호 일치
    static int fiveCorrect = 0;             // 5개 번호 일치
    static int fiveBonusCorrect = 0;        // 5개 번호 + 보너스 번호 일치
    static int sixCorrect = 0;              // 6개 번호 일치
    public static final List<Lotto> lottos = new ArrayList<>(); // 무작위로 뽑은 로또 번호

    /* 구입금액에 따른 로또 구입 개수 계산 */
    static int calculateNumberOfLotto() {
        // 1000원 단위로 나누어 떨어지지 않는 경우 예외처리 필요
        count = inputMoney / 1000;
        return count;
    }

    /* 구입금액만큼 로또 번호 생성 */
    static void createLotto(){
        for(int i = 0; i < inputMoney/1000; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
    }

    /* 로또 번호 오름차순 정렬 */
    static List<Integer> sortLottoNumber(List<Integer> lottoNumber){
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
    /* 로또 당첨 번호 계산 */
    static void calculateLotto(){
        for (Lotto lotto : lottos) {
            int count = calculateLottoNumberIsCorrect(lotto.getNumbers());
            boolean bonus = calculateBonusIsCorrect(lotto.getNumbers());
            if (count == 3) {
                threeCorrect += 1;
            } else if (count == 4) {
                fourCorrect += 1;
            } else if (count == 5 && !bonus) {
                fiveCorrect += 1;
            } else if (count == 5 && bonus) {
                fiveBonusCorrect += 1;
            } else if (count == 6) {
                sixCorrect += 1;
            }
        }
    }

    /* 각각의 로또 당첨 번호 계산 */
    static int calculateLottoNumberIsCorrect(List<Integer> lotto){
        int count = 0;
        for(int i = 0; i < lotto.size(); i++){
            if(Objects.equals(lotto.get(i), correctNumber.get(i))){
                count += 1;
            }
        }
        return count;
    }

    /* 보너스 번호 맞는지 계산 */
    static boolean calculateBonusIsCorrect(List<Integer> lotto){
        boolean isBonus = false;
        for(int l:lotto){
            if(l == bonusNumber){
                isBonus = true;
                break;
            }
        }
        return isBonus;
    }

    /* 수익률 계산 */
    static float calculateRateOfReturn(){
        float rateOfReturn = 0;
        double total = 5000 * threeCorrect + 50000 * fourCorrect + 1500000 * fiveCorrect + 30000000 * fiveBonusCorrect + 2000000000 * sixCorrect;
        rateOfReturn = (float) (total / inputMoney) * 100;
        return rateOfReturn;
    }
}
