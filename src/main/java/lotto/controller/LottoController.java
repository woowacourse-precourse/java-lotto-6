package lotto.controller;

import java.util.List;
import java.util.Set;
import lotto.controller.dto.CreateUserDto;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.views.InputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }
    public void run(){
        CreateUserDto createUserDto = checkUser(inputView);
        createUserDto.setPublishedLotto(lottoService.publish(createUserDto.getQuantity()));
        User user = User.create(createUserDto);
        WinningNumbers winningNumbers = getWinningNumbers();
    }
    private CreateUserDto checkUser(InputView inputView){
        long purchaseAmount = inputView.getPurchaseAmount();
        CreateUserDto createUserDto = new CreateUserDto(purchaseAmount);
        return createUserDto;
    }
    private WinningNumbers getWinningNumbers(){
        Set<Integer> originalWinningNumbers = inputView.getOriginalWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();
        return lottoService.getWinningNumbers(originalWinningNumbers, bonusNumber);
    }
}
