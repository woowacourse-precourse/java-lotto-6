package lotto.view.controller;

import lotto.lotto.dto.LottoDto;
import lotto.view.service.ViewInputService;
import lotto.view.service.ViewOutputService;

import java.util.List;

public class ViewController {

    private final ViewInputService viewInputService;
    private final ViewOutputService viewOutputService;

    public ViewController(ViewInputService viewInputService, ViewOutputService viewOutputService) {
        this.viewInputService = viewInputService;
        this.viewOutputService = viewOutputService;
    }
}
