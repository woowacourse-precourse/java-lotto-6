package lotto;
import camp.nextstep.edu.missionutils.Randoms; import java.util.ArrayList; import java.util.List; import java.util.Collections;

public class LottoModel {
    private int lottoPrice;
    private Lotto winningLotto;
    private List<Lotto> boughtLottos;
    private int bonusNumber;
    private int[] lottoRank = new int[5];
    private int profit = 0;

    public LottoModel() {
        lottoPrice = LottoControl.inputLottoPrice();
        boughtLottos =  generateLottos(lottoPrice);

        LottoView.printLottoAmount(lottoPrice);
        LottoView.printGeneratedLottos(boughtLottos);

        winningLotto = LottoControl.inputWinningNumbers();
        bonusNumber = LottoControl.inputBonusNumber(winningLotto);

        checkLottoRank();
        LottoView.printRankInfo(lottoRank);

        LottoView.printProfitRate(calcLottoProfit());
    }

    private List<Lotto> generateLottos(int lottoPrice) {
        List<Lotto> generatedLottos = new ArrayList<>();

        for(int i = 0; i < lottoPrice / 1000; i++) {
            List<Integer> generatedNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(generatedNumbers);
            generatedLottos.add(new Lotto(generatedNumbers));
        }

        return generatedLottos;
    }

    private void checkLottoRank() {
        for(Lotto boughtLotto : boughtLottos) {
            if(checkWonNumber(boughtLotto) == 6) {
                lottoRank[0]++;
                profit += 2000000000;
            } else if(checkWonNumber(boughtLotto) == 5 && checkBonusNumber(boughtLotto)) {
                lottoRank[1]++;
                profit += 30000000;
            } else if(checkWonNumber(boughtLotto) == 5) {
                lottoRank[2]++;
                profit += 1500000;
            } else if(checkWonNumber(boughtLotto) == 4) {
                lottoRank[3]++;
                profit += 50000;
            } else if(checkWonNumber(boughtLotto) == 3) {
                lottoRank[4]++;
                profit += 5000;
            }
        }
    }

    private int checkWonNumber(Lotto boughtLotto) {
        int wonNumber = 0;
        for(int number : boughtLotto.getNumbers()) {
            if(winningLotto.getNumbers().contains(number)) {
                wonNumber++;
            }
        }

        return wonNumber;
    }

    private boolean checkBonusNumber(Lotto boughtLotto) {
        return boughtLotto.getNumbers().contains(bonusNumber);
    }

    private double calcLottoProfit() {
        return Math.round((double)profit / (double)lottoPrice * 1000) / 10.0;
    }
}

