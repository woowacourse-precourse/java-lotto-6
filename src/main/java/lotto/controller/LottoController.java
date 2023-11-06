package lotto.controller;

import java.util.Map;
import java.util.Set;
import lotto.controller.dto.CreateUserDto;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.domain.WinningNumbers;
import lotto.global.ExceptionHandler;
import lotto.service.LottoService;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        User user = ExceptionHandler.input(this::createUser);
        outputView.lottoQuantityAndNumber(user.getLotto());

        WinningNumbers winningNumbers = getWinningNumbers();
        Map<Prize, Integer> rewardCount = lottoService.getRewardCount(user.getLotto(), winningNumbers);
        outputView.winningRecord(rewardCount);

        double rewardRatio = lottoService.getRewardRatio(user.getPurchaseAmount(), rewardCount);
        outputView.rewardRatioRecord(rewardRatio);
    }

    private User createUser(){
        CreateUserDto createUserDto = checkUser();
        createUserDto.setPublishedLotto(lottoService.publish(createUserDto.getQuantity()));
        return User.create(createUserDto);
    }

    private CreateUserDto checkUser() {
        long purchaseAmount = ExceptionHandler.input(inputView::getPurchaseAmount);
        CreateUserDto createUserDto = new CreateUserDto(purchaseAmount);
        return createUserDto;
    }

    private WinningNumbers getWinningNumbers() {
        Set<Integer> originalWinningNumbers = ExceptionHandler.input(inputView::getOriginalWinningNumbers);
        int bonusNumber = ExceptionHandler.process(inputView::getBonusNumber, originalWinningNumbers);
        return lottoService.getWinningNumbers(originalWinningNumbers, bonusNumber);
    }
}
