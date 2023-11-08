## Domain

- 랜덤한 로또를 발행한다 [LottoPublisher]
    - 랜덤한 로또를 발행하는 책임을 가진다 [publishLotto()]

- 랜덤한 로또 숫자를 검증한다 [Lotto]
    - 랜덤한 로또 번호화 비교하는 책임을 가진다 [compareWinningNumbers()]
    - 로또의 숫자의 길이를 확인하는 책임을 가진다
    - 로또의 숫자에 중복이 있는지 확인하는 책임을 가진다

- 로또 결과를 출력하는 책임을 가진다 [LottoResult]

- 로또 순위를 결정하는 책임을 가진다 [WinningLotto]

## View

- 사용자의 입력값을 받는다 [LottoInputView]
    - 구매할 로또 수를 입력 받는 책임을 가진다 [getLottoPurchaseAmountInput()]
    - WinningNumber를 입력 받는 책임을 가진다 [getWinningNumbers()]

- 사용자의 입력값에 따른 결과를 출력한다 [LottoOutputView]
    - 랜덤으로 생성된 로또의 결과값을 출력하는 책임을 가진다 [presentLottoList()]
    - 로또 결과를 출력하는 책임을 가진다 [presentLottoResult()]

## Controller

- 전체적인 로또 게임의 흐름을 제어한다 [LottoController]
    - 전체적인 로또 게임 프로세스를 실행한다 [run()]

## Service

- 전체적인 로또 게임의 어플리케이션 로직을 처리한다 [LottoService]
    - 로또를 구매하는 어플리케이션 로직을 처리해야 한다 [purchaseLotto()]
    - 랜덤으로 생성된 로또값을 비교하는 어플리케이션 로직을 처리해야 한다 [compareLotto()]

## Repository

- 로또를 저장한다 [LottoRepository]
    - 로또 리스트를 저장한다 [saveAll()]
    - 저장된 모든 로또 리스트를 반환한다 [findAll()]
    - 단건의 로또를 저장한다 [save()]
    - 데이터베이스에 저장된 로또를 제거한다 [clear()]
