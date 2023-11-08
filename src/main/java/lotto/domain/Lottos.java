package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;
import java.util.*;

public class Lottos {
    private List<Lotto> lottos;
    private int lottoCnt;
    public Lottos() {
    }
    public void setLottos(String purchase) {
        try {
            validateCnt(purchase);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        this.lottoCnt = convertLottoCnt(purchase);
        this.lottos = drawLottos();
    }

    private List<Lotto> drawLottos() {
        lottos = new ArrayList<>();
        List<Lotto> drawResult = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            drawResult.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    Constant.START_INCLUSIVE,
                    Constant.END_ENCLUSIVE,
                    Constant.LOTTO_NUMBER)));
        }
        return drawResult;
    }

    private int convertLottoCnt(String purchase) {
        return (Integer.parseInt(purchase) / 1000);
    }

    private void validateCnt(String purchase) {
        try {
            if (!purchase.matches(Constant.numberRegex)) {
                throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_REGEX.getMessage());
            }
            if ((Integer.parseInt(purchase) % 1000) != 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_PURCHASE.getMessage());
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int getLottoCnt() {
        return lottoCnt;
    }

    public List<String> anounceLottos() {
        List<String> lottoResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int[] lottoNum = lotto.convertArray();
            Arrays.sort(lottoNum);
            lottoResult.add(Arrays.toString(lottoNum));
        }
        return lottoResult;
    }


    public Map<String, Integer> calculateResult(Winning winning) {
        Map<String, Integer> result = new HashMap<>();

        for (String status : Constant.lottoResult.values()) {
            result.put(status, 0);
        }

        Lotto winningLotto = winning.getWinningLotto();
        int bonusNum = winning.getBonusNum();

        for (Lotto lotto : lottos) {
            int matchingNum = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            if (matchingNum == 5) {
                if (lotto.contain(bonusNum)) {
                    matchingNum = 7;
                }
            }

            String lottoStatus = Constant.lottoResult.get(matchingNum);
            if (lottoStatus != null) {
                result.put(lottoStatus, result.get(lottoStatus) + 1);
            }
        }
        return result;
    }

    public float calculateProfit(Map<String, Integer> result) {
        long reward = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String lottoStatus = entry.getKey();
            int count = entry.getValue();
            reward += (long) (Constant.prize.get(lottoStatus)) * count;
        }
        return reward / (float) (lottoCnt * 10);
    }
}
