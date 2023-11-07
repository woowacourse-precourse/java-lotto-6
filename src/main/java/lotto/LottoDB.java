package lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDB {


    // instance
    private final ArrayList<Integer> userLottoNumbers;
    private final ArrayList<Integer> winningCount;
    private int lottoGameCount;
    private int lottoBonusNumber;
    private long lottoTotalPrice;
    private BigDecimal lottoTotalWinningRate;

    public LottoDB() {
        userLottoNumbers = new ArrayList<>();
        winningCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        lottoGameCount = 0;
        lottoBonusNumber = 0;
        lottoTotalPrice = 0;
        lottoTotalWinningRate = BigDecimal.valueOf(0.0);
    }

    public int getLottoGameCount() {
        return lottoGameCount;
    }

    public int getLottoBonusNumber() {
        return lottoBonusNumber;
    }

    public int getNumberOfWinning(int index) {
        return winningCount.get(index);
    }

    public long getLottoTotalPrice() {
        return lottoTotalPrice;
    }

    public BigDecimal getLottoTotalWinningRate() {
        return lottoTotalWinningRate;
    }

    public ArrayList<Integer> getWinningCount() {
        return winningCount;
    }

    public void storeLottoNumbers(List<Integer> lottoNumbers) {
        userLottoNumbers.addAll(lottoNumbers);
    }

    public void setLottoGameCount(int lottoGameCount) {
        this.lottoGameCount = lottoGameCount;
    }

    public void setLottoBonusNumber(int lottoBonusNumber) {
        this.lottoBonusNumber = lottoBonusNumber;
    }

    public void setLottoTotalPrice(long totalPrice) {
        this.lottoTotalPrice = totalPrice;
    }

    public void setLottoTotalWinningRate(BigDecimal totalWinningRate) {
        this.lottoTotalWinningRate = totalWinningRate;
    }

    public ArrayList<Integer> getOneLottoNumbers(int startIndex) {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        for (int index = startIndex; index < startIndex + 6; index++) {
            lottoNumbers.add(userLottoNumbers.get(index));
        }
        return lottoNumbers;
    }

    public void saveWinningCount(int correctNumber) {
        if (correctNumber == 3) {
            int nowValue = winningCount.get(4);
            nowValue += 1;
            winningCount.set(4, nowValue);
        }
        if (correctNumber == 4) {
            int nowValue = winningCount.get(3);
            nowValue += 1;
            winningCount.set(3, nowValue);
        }
        if (correctNumber == 5) {
            int nowValue = winningCount.get(2);
            nowValue += 1;
            winningCount.set(2, nowValue);
        }
        if (correctNumber == 6) {
            int nowValue = winningCount.get(0);
            nowValue += 1;
            winningCount.set(0, nowValue);
        }
        if (correctNumber == 7) {
            int nowValue = winningCount.get(1);
            nowValue += 1;
            winningCount.set(1, nowValue);
        }
    }


}
