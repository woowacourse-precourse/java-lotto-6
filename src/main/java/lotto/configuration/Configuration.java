package lotto.configuration;

import io.output.ConsoleWriter;
import lotto.controller.LottoController;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoStore;
import lotto.domain.lotto.RandomLottoGenerator;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

/**
 * 싱글턴 객체입니다.
 * <p>
 * 한 번에 LottoController가 의존하는 모든 객체를 생성 및 주입하여 반환합니다..
 */
public final class Configuration {

    private final LottoController lottoController;

    /**
     * 외부 생성자 접근을 제한합니다.
     */
    private Configuration() {
        final InputView inputView = new InputView(new ConsoleWriter());
        final OutputView outputView = new OutputView(new ConsoleWriter());
        final LottoGenerator lottoGenerator = new RandomLottoGenerator();
        final LottoStore lottoStore = new LottoStore(lottoGenerator);
        final LottoRepository lottoRepository = new LottoRepository();

        final LottoService lottoService = new LottoService(
                lottoStore,
                lottoRepository
        );

        this.lottoController = new LottoController(inputView, outputView, lottoService);
    }

    /**
     * 싱글턴 `Configuration` 객체를 반환합니다.
     */
    public static Configuration getInstance() {
        return ConfigurationHolder.INSTANCE;
    }

    /**
     * 미리 설정된 LottoController를 반환합니다.
     */
    public LottoController getLottoController() {
        return lottoController;
    }

    /**
     * static inner class를 활용하여 Configuration 인스턴스를 싱글톤으로 만듬.
     * <p>
     * Configuration은 프로그램 실행 후 첫 참조 시, 메모리에 로드.
     * <p>
     * ConfigurationHolder는 Configuration.getInstance()가  호출될 때 메모리에 로드.
     * <p>
     * 즉, 이 때 INSTANCE가 생성됨.
     * <p>
     * 정확하지는 않으나, 찾아본 결과 JVM의 클래스 로딩 메커니즘 자체가 스레드 세이프를 보장한다고 함.
     * <p>
     * -> '클래스 초기화'를 위한 스레드가 하나만 존재하도록 만들었기 때문이라고 함
     * <p>
     * 그래서 Configuration.getInstance() 호출
     * <p>
     * -> ConfigurationHolder 클래스 로드
     * <p>
     * -> INSTANCE 생성 및 초기화
     * <p>
     * 위 과정이 일어나며 멀티 스레드 환경에서도 안전한 싱글톤을 보장한다고 함.
     * <p>
     * 단, 이 방법의 단점은 클래스 로딩 시점에 초기화 되는 것이 해당 클래스의 정적 멤버뿐이기 때문에,
     * <p>
     * 초기화에 필요한 모든 것을 클래스 로딩 시점에 결정해야 하며, 이 때무에 동적 설정 및 초기화가 어렵다고 함.
     * <p>
     * 로또 프로그램의 경우, 동적인 교체가 필요 없기 때문에 사용 가능.
     * <p>
     * 또한 리플렉션으로 인한 강제 변경에는 취약하다고 함.
     * <p>
     * 이 패턴을 Initialization-on-demand holder idiom이라고 부른다고 함.
     */
    private static final class ConfigurationHolder {
        private static final Configuration INSTANCE = new Configuration();
    }

}
