package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Rank;
import lotto.io.BonusNumberInputManager;
import lotto.io.PaymentInputManager;
import lotto.io.WinningNumberInputManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {
    private final WinningNumberInputManager winningNumberInputManager;
    private final PaymentInputManager paymentInputManager;
    private final BonusNumberInputManager bonusNumberInputManager;
    private Integer bonusNumber;
    private Integer lottoCount;
    private final Set<Rank> rankBoard = new HashSet<>();
    private static LottoService INSTANCE;

    private LottoService() {
        this.winningNumberInputManager = WinningNumberInputManager.getInstance();
        this.paymentInputManager = PaymentInputManager.getInstance();
        this.bonusNumberInputManager = BonusNumberInputManager.getInstance();
        this.bonusNumber = 0;
    }

    public static LottoService getInstance() {
        if (INSTANCE == null) INSTANCE = new LottoService();
        return INSTANCE;
    }

    /**
     * 구매한 로또들 반환
     */
    public List<Lotto> buyLottos() {
        lottoCount = paymentInputManager.input();
        LottoShop lottoShop = new LottoShop(lottoCount);
        lottoShop.displayLottos();
        return lottoShop.getLottos();
    }

    /**
     * 당첨번호 반환
     */
    public Lotto chooseWinningLottos() {
        List<Integer> winningNumbers = null;
        boolean willCheckBonusNumber;
        do try {
            winningNumbers = winningNumberInputManager.input();
            bonusNumber = bonusNumberInputManager.input();
            if (!validateBonusNumber(winningNumbers)) throw new IllegalArgumentException("[ERROR] 적절하지 않은 보너스 번호입니다.");
            willCheckBonusNumber = false;
        } catch (IllegalArgumentException e) {
            willCheckBonusNumber = true;
        } while (willCheckBonusNumber);
        return new Lotto(winningNumbers);
    }

    private boolean validateBonusNumber(List<Integer> winningNumbers) {
        return !winningNumbers.contains(bonusNumber);
    }

    public void executeLotto() {
        List<Lotto> boughtLottos = buyLottos();
        Lotto winningLotto = chooseWinningLottos();
        for (Lotto boughtLotto : boughtLottos)
            decideRank(boughtLotto, winningLotto);
    }

    private void decideRank(Lotto boughtLotto, Lotto winningLotto) {
        Integer matchingCount = boughtLotto.countMatchingNumber(winningLotto, bonusNumber);
        Boolean isMatch = boughtLotto.checkMatchingNumber(bonusNumber);
        rankBoard.add(Rank.of(isMatch, matchingCount));
    }

    public void displayResult(){
        System.out.println("당첨 통계\n" + "---");
        displayRankCount();
        displayEarningRate();
    }

    private void displayEarningRate() {
        int total=0;
        for (Rank rank: Rank.values())
            total+=countRankOf(rank)*rank.getPrizeMoney();
        System.out.println("총 수익률은 "+getEarningRate(total)+"%입니다.");
    }

    private double getEarningRate(double total) {
        return (double) Math.round(total / (lottoCount * 1000) * 1000) / 10;
    }

    private void displayRankCount() {
        System.out.println("3개 일치 (5,000원) - "+countRankOf(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - "+countRankOf(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+countRankOf(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+countRankOf(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+countRankOf(Rank.FIRST)+"개");
    }

    private int countRankOf(Rank rank){
        return (int)rankBoard.stream().filter(r->r.equals(rank)).count();
    }
}
