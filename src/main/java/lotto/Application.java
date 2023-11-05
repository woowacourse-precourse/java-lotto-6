package lotto;

import lotto.controller.SystemController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            SystemController systemController = SystemController.create();
            systemController.showResult();
        } catch (IllegalStateException e) {
            OutputView.exceptionMessage(e);
        }
        // TODO 2023-11-06 04:01 프로젝트 제출 전 임포트 문 최적화 및 컨벤션에 맞춰 정리
    }
}
