package lotto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class UserTest {

    static final int BUY_LOTTO_EACH = 2;
    static final int MONEY = 5000;
    WinningLotto winningNumber;
    UserWallet userWallet;

    List<Lotto> myLottoNumbers = new ArrayList<>();
    List<LottoRank> winningsMoney = new ArrayList<>();

    @BeforeEach
    void init(){
        userWallet = UserWallet.createWallet(MONEY);
    }

    @Test
    @DisplayName("로또_등수_테스트")
    void winLottoCheck() {
        myLottoNumbers =  List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        winningNumber = WinningLotto.of(List.of(1,2,3,4,5,8), 7);

            myLottoNumbers.forEach(
                    lotto -> winningsMoney.add(lotto.getMyRank(winningNumber))
            );

        Assertions.assertEquals(winningsMoney.get(0), LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또_구매_갯수_테스트")
    void buyLotto() {

        List<Lotto> myLottoNumbers = LottoNumberCreator.myLottoNumbersFrom(2);
        Assertions.assertEquals( myLottoNumbers.size(), 2);
    }
}