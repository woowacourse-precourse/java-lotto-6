# 로또 게임 구현 계획

## 기능 목록

1. 프로그램의 진입점으로 `Application.main()`을 생성합니다.
2. 로또 게임 도메인 모델을 구현합니다:
   - 제공된 문서에 따라 `Lotto` 클래스를 구현합니다.
   - 무작위 로또 티켓을 생성하는 `LottoGenerator`를 구현합니다.
   - 구입한 로또 티켓을 나타내는 `LottoTicket`를 구현합니다.
   - 게임 흐름을 처리하는 `LottoMachine`을 구현합니다.
3. 입력 유효성 검사 및 오류 처리를 구현합니다.
4. 난수 생성으로 복권 추첨 기능을 구현합니다.
5. 상금 계산 및 결과 출력을 구현합니다.
6. 입력 및 출력을 위해 콘솔을 사용하여 사용자 인터페이스를 구현합니다.
7. 도메인 로직의 정확성을 확인하기 위해 단위 테스트를 수행합니다.


## Todos

1. Create domain classes with basic structure (LottoNumber, Lotto, LottoTicket, LottoMachine).
2. Implement LottoNumber validation logic.
3. Implement generation of random Lotto tickets.
4. Define PrizeCategory Enum with prize criteria.
5. Implement reading user input for purchase amount and validate it.
6. Implement reading winning numbers and the bonus number from user input and validate them.
7. Implement logic to check the matching numbers between a Lotto ticket and the winning numbers.
8. Implement prize calculation based on the number of matches.
9. Implement output formatting and display logic for the UI.
10. Write unit tests for domain logic.
11. Conduct manual testing, fix any bugs, and make final adjustments.
12. Update README.md with final documentation.
