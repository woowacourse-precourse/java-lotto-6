package lotto;

import java.util.List;

public class PlayLotto {
    protected static final int lottoPrice = 1000;
    private UserIO userIO;
    private LottoManager lottoManager;
    private LottoGame lottoGame;
    private Calculator calculator;

    public PlayLotto() {
        this.userIO = new UserIO();
        this.lottoManager = new LottoManager();
        this.lottoGame = new LottoGame();
        this.calculator = new Calculator();
    }
    public PlayLotto(UserIO userIO, LottoManager lottoManager, LottoGame lottoGame, Calculator calculator){
        this.userIO=userIO;
        this.lottoManager=lottoManager;
        this.lottoGame=lottoGame;
        this.calculator=calculator;
    }

    public void play() {
        buy();
        set();
        check();
        result();

    }

    private void buy() {
        int amount = userIO.getAmount();
        for (; amount > 0; amount--) {
            Lotto currentLotto = lottoGame.getLotto();
            currentLotto.printNumbers();
            lottoManager.addLotto(currentLotto);
        }
    }

    private void set() {
        while (true) {
            try {
                lottoGame.setWinningLotto(userIO.getNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoGame.setBonusNumber(userIO.getBonusNumber(lottoGame.getWinningLotto()));
    }

    private void check() {
        List<Lotto> lottoList = lottoManager.getLottoList();
        for (Lotto lotto : lottoList) {
            lottoGame.checkLotto(lotto);
        }
    }

    private void result() {
        userIO.printStatistics();
        int lottoPrizeMoney = 0;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            System.out.println(lottoPrize);
            lottoPrizeMoney += lottoPrize.getPrize() * lottoPrize.getCount();
        }
        double rate = calculator.calculateRate(lottoPrizeMoney, lottoManager.getLottoList().size() * lottoPrice);
        userIO.printLottoResult(rate);
    }
}
