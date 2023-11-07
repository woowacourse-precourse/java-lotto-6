package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayInputStream;


public class PlayLottoTest {
    private UserIO userIO;
    private LottoManager lottoManager;
    private LottoGame lottoGame;
    private Calculator calculator;
    private PlayLotto playLotto;

    @BeforeEach
    public void setUp() {
        userIO=new UserIO();
        lottoManager = new LottoManager();
        lottoGame = new LottoGame();
        calculator = new Calculator();
    }

    @Test
    public void testPlay() {
        MockitoAnnotations.initMocks(this);
        UserIO spyUserIO = Mockito.spy(userIO);
        LottoManager spyLottoManager = Mockito.spy(lottoManager);
        LottoGame spyLottoGame = Mockito.spy(lottoGame);
        Calculator spyCalculator = Mockito.spy(calculator);
        playLotto = new PlayLotto(spyUserIO,spyLottoManager,spyLottoGame,spyCalculator);
        ByteArrayInputStream in = new ByteArrayInputStream("3000\n1,3,5,7,9,13\n11".getBytes());
        System.setIn(in);
        InOrder inOrder = Mockito.inOrder(spyLottoGame, spyLottoManager, spyUserIO, spyCalculator);
        playLotto.play();
        inOrder.verify(spyUserIO).getAmount();
        for(int i=0;i<3;i++){
            inOrder.verify(spyLottoGame).getLotto();
            inOrder.verify(spyLottoManager).addLotto(Mockito.any(Lotto.class));
        }
        inOrder.verify(spyUserIO).getNumbers();
        inOrder.verify(spyLottoGame).setWinningLotto(Mockito.anyList());
        inOrder.verify(spyUserIO).getBonusNumber(Mockito.any(Lotto.class));
        inOrder.verify(spyLottoGame).setBonusNumber(Mockito.anyInt());
        inOrder.verify(spyLottoManager).getLottoList();
        inOrder.verify(spyLottoGame, Mockito.times(3)).checkLotto(Mockito.any(Lotto.class));
        inOrder.verify(spyUserIO).printStatistics();
        inOrder.verify(spyCalculator).calculateRate(Mockito.anyInt(), Mockito.anyInt());
        inOrder.verify(spyUserIO).printLottoResult(Mockito.anyDouble());
    }

}
