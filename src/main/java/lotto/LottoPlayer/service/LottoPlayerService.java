package lotto.LottoPlayer.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto.entity.Lotto;
import lotto.Lotto.model.WinnerGroup;
import lotto.Lotto.repository.LottoRepository;
import lotto.LottoPlayer.dto.WinningStatistic;
import lotto.LottoPlayer.entity.LottoPlayer;
import lotto.LottoPlayer.repository.LottoPlayerRepository;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Lotto.model.WinnerGroup.*;

public class LottoPlayerService {


    private static final int LOTTO_PRICE = 1000;

    private static final int THOUSAND = 1000;

    private static final double TEN = 10.0;
    private static final int ZERO = 0;
    LottoPlayerRepository playerRepository = LottoPlayerRepository.getInstance();
    LottoRepository lottoRepository = LottoRepository.getInstance();

    UIService uiService = new UIService();

    //구매 금액을 설정하는 함수
    public void setPurchaseAmount(int purchase_amount) {
        LottoPlayer player = new LottoPlayer(purchase_amount);
        playerRepository.setLottoPlayer(player);
    }

    //입력받은 개수만큼 로또를 발행하는 함수
    public List<Lotto> issueLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
           List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
           Lotto lotto = new Lotto(lottoNumbers);
           lottoList.add(lotto);
        }
        return lottoList;
    }

    //발행한 로또를 저장하는 함수
    public void setIssuedLotto(List<Lotto> issuedLotto, int issuedLottoCount) {
        LottoPlayer player = playerRepository.getLottoPlayer();
        player.setIssuedLotto(issuedLotto);
        player.setPurchaseAmount(issuedLottoCount);
        playerRepository.setLottoPlayer(player);
    }

    //입력된 구입 금액만큼 발행 장 수를 계산하는 기능
    public int calculateLottoCount(int money) {
        return money / 1000;
    }

    //입력받은 로또 리스트의 번호를 오름차순 정렬하는 함수
    public List<Lotto> sortIssuedLottoAscending(List<Lotto> lottoList) {
        List<Lotto> sortedLottoList = new ArrayList<>(lottoList.size());

        for (Lotto lotto : lottoList) {
            Lotto newLotto = new Lotto(lotto.getNumbers());
            List<Integer> numbers = new ArrayList<>(newLotto.getNumbers());
            numbers.sort(Integer::compareTo);
            sortedLottoList.add(newLotto);
        }
        return sortedLottoList;
    }

    //당첨 통계를 계산하는 함수
    public WinningStatistic checkWinningStatistic() {
        int matchCount;
        boolean bonusMatch;
        WinningStatistic statisticResult = new WinningStatistic();

        //플레이어의 발행된 로또를 가져온다.
        LottoPlayer player = playerRepository.getLottoPlayer();
        List<Lotto> issuedLotto = player.getIssuedLotto();

        //당첨 번호와 보너스 번호를 가져온다.
        Lotto winningLotto = lottoRepository.getWinningLotto();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = lottoRepository.getBonusNumber();


        for (Lotto lotto : issuedLotto) {
            List<Integer> lottoNumbers = new ArrayList<>();
            lottoNumbers.addAll(lotto.getNumbers());
            lottoNumbers.retainAll(winningNumbers);

            matchCount = lottoNumbers.size();
            bonusMatch = lottoNumbers.contains(bonusNumber);

            statisticResult = checkRank(matchCount, bonusMatch, statisticResult);
        }

        return statisticResult;
    }

    //입력된 조건의 당첨 등급을 계산하는 함수
    private WinningStatistic checkRank(int matchCount, boolean bonusMatch, WinningStatistic result) {
        if(matchCount == FIRST_PRIZE.getMatchCount()) {
            result.increaseFirstPrizeCount();
            return result;
        }
        if(matchCount == SECOND_PRIZE.getMatchCount() && bonusMatch) {
            result.increaseSecondPrizeCount();
            return result;
        }
        if(matchCount == THIRD_PRIZE.getMatchCount()) {
            result.increaseThirdPrizeCount();
            return result;
        }
        if(matchCount == FOURTH_PRIZE.getMatchCount()) {
            result.increaseFourthPrizeCount();
            return result;
        }
        if(matchCount == FIFTH_PRIZE.getMatchCount()) {
            result.increaseFifthPrizeCount();
            return result;
        }
        return result;
    }

    public float calculateTotalProfitRate(WinningStatistic statistics) {
        LottoPlayer player = playerRepository.getLottoPlayer();
        int investment = player.getPurchaseAmount()*LOTTO_PRICE;
        int profit = statistics.getFifthPrizeCount()*FIFTH_PRIZE.getPrize()
                + statistics.getFourthPrizeCount()*FOURTH_PRIZE.getPrize()
                + statistics.getThirdPrizeCount()*THIRD_PRIZE.getPrize()
                + statistics.getSecondPrizeCount()*SECOND_PRIZE.getPrize()
                + statistics.getFirstPrizeCount()*FIRST_PRIZE.getPrize();

        float profitRate = (float) (THOUSAND * profit) / investment;
        float roundedProfitRate = (float) (Math.round(profitRate) / TEN);


        return roundedProfitRate;
    }

    public int getMoney() {
        int money = ZERO;
        try {
            money = uiService.readMoney();
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return money + getMoney();
    }
}
