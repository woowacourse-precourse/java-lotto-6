package lotto.controller;

import java.util.List;
import lotto.controller.dto.CreateUserDto;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.views.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }
    public void run(){
        CreateUserDto createUserDto = checkUser();
        buyLotto(createUserDto);
        User user = User.create(createUserDto);

    }
    private CreateUserDto checkUser(){
        InputView inputView = new InputView();
        long purchaseAmount = inputView.getPurchaseAmount();
        CreateUserDto createUserDto = new CreateUserDto(purchaseAmount);
        return createUserDto;
    }
    private void buyLotto(CreateUserDto userDto){
        List<Lotto> publishedLotto = lottoService.publish(userDto.getQuantity());
        userDto.setPublishedLotto(publishedLotto);
    }
}
