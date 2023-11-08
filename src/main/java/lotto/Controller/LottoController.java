package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import lotto.Model.User;
import lotto.Model.CalculateWinning;
import lotto.View.LottoView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    final int LOTTOPRICE = 1000;

    private User user;
    private LottoView view;
    private CalculateWinning calculateWinning;
    private List<User> lottos = new ArrayList<>(); //사용자가 가지고 있는 로또들
    private List<Integer> winning = new ArrayList<>(); // 당첨 번호
    private int bonus;
    private int userBuyCount;

    private int[] rankings = new int[8];

    public LottoController(User user, LottoView lottoView, CalculateWinning calculateWinning) {
        this.user = user;
        this.view = lottoView;
        this.calculateWinning = calculateWinning;
    }

    public void lottoGame() {
        inputAmountOfLotto();
        howManyLottos();
        inputWinningNum();
        inputBonus();
        result();
    }

    public void inputAmountOfLotto() {
        inputPrice();
        amountLottos();
    }

    public void howManyLottos() {
        setLottoTickets();
    }

    public void inputWinningNum() {
        view.enter();
        view.printWinningNum();
        setWinning();
        view.enter();
    }

    public void inputBonus() {
        view.printBonusNum();
        bonus = view.getBonus();
        view.enter();
    }

    public void result() {
        view.printResult();
        setUserWinning();
        setRankings();
        printResults();
        calculatePrize();
        printRate();
    }

    public void inputPrice() {
        view.printInputPrice();
        view.setPrice();
    }

    public void amountLottos() {
        setUserBuyCount(view.getPrice());
        view.printNumOfLotto(userBuyCount);
    }

    public List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public void setLottoTickets() {
        for (int i = 0; i < userBuyCount; i++) {
            User user = new User();
            setLottoNumber(user);
            printUserLottos(user);
            lottos.add(user);
        }
    }

    public void setLottoNumber(User user) {
        user.setUserLotto(makeLotto());
    }

    public void setUserBuyCount(int price) {
        userBuyCount = price / LOTTOPRICE;
    }

    public void printUserLottos(User user) {
        view.printLottos(user.getUserLotto());
    }

    public void setWinning() {
        winning = view.getWinningNumber();
    }

    public void setUserWinning() {
        for (User user : lottos) {
            user.setHasBonus(bonus);
            List<Integer> retainedList = user.getUserLotto().stream().filter(winning::contains)
                    .collect(Collectors.toList());
            user.setUserLotto(retainedList);
        }
    }

    public void setRankings() {
        calculateWinning.setRankings(lottos);
        rankings = calculateWinning.getRankings();
    }

    public void printResults() {
        view.printResults(rankings);
    }

    public void print() {
        for (User user : lottos) {
            System.out.println(user.getUserLotto());
        }
    }

    public void calculatePrize() {
        calculateWinning.thirdPrize(rankings[3]);
        calculateWinning.fourthPrize(rankings[4]);
        calculateWinning.fifthPrize(rankings[5]);
        calculateWinning.fifthBonusPrize(rankings[7]);
        calculateWinning.sixPrize(rankings[6]);
        calculateWinning.setRatingReturn(view.getPrice());
    }

    public void printRate() {
        view.printTotalIncome(calculateWinning.getRate());
    }

}
