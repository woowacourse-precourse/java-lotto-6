## Domain
- 랜덤한 로또를 발행한다 [LottoPublisher]
  - 랜덤한 로또를 발행하는 책임을 가진다 [publishLotto()]

- 랜덤한 로또 숫자를 검증한다 [Lotto]
- 입력한 당첨 번호화 로또 번호를 비교한다 [LottoComparator]

## View
- 사용자의 입력값을 받는다 [LottoInputView]
- 사용자의 입력값에 따른 결과를 출력한다 [LottoOutputView]

## Controller
- 전체적인 로또 게임의 흐름을 제어한다 [LottoController]
  - 전체적인 로또 게임 프로세스를 실행한다 [run()]

## Service
- 전체적인 로또 게임의 어플리케이션 로직을 처리한다 [LottoService]

## Repository
- 로또를 저장한다 [LottoRepository]
  - 로또 리스트를 저장한다 [saveAll()]
