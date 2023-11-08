기능 목록
1. 로또 구입 금액 입력받기
- 1000원 단위이고 예외 발생시 에러 메세지 다시 입력 받는다.
2. 로또 생성
3. 당첨 번호 입력받기
- 예외 발생시 경고 문구 후 해당 부분 입력 받기
- 대조 후 당첨 내역 생성
- 당첨 내역 출력
- 수익률 계산

전체 모델링

Application
1. Input을 이용하여 입력
- 돈 입력 받기 (예외 가능성 있음)
- 로또 당첨 번호 생성
- 서비스 번호 생성
2. LottoControler 연결
- 돈 주고 생성된 로또 받기 (예외 가능성 있음)
- 당첨 번호 및 서비스 번호를 주고 당첨 내역 받기 (예외 가능성 있음)
- 수익률 받기
3. Output을 이용하여 받은 정보 출력
- 생성된 로또 번호 출력
- 당첨 내역 출력
- 수익률 출력

Lotto
1. 로또 생성
2. 당첨 번호 대조 후 등 수 계산
3. 유효 로또 검증 
- Validation 클래스를 통해 Error 검증

LottoControler
1. 로또 번호 생성
2. 로또 번호 정렬
3. 로또 객체 리스트 생성
4. 로또 객체 리스트 초기화
5. 돈에 따라 생성된 로또 개수 검증
6. Lotto의 함수를 이용하여 당첨 내역 제작 
7. 기존 받은 돈과 전체 수익을 비교하여 수익률 산출
8. Application과의 연결
- 생성한 로또 정보 건내기
- 당첨 내역 정보 건내기
- 수익률 정보 건내기


Input
1. 구입 금액 입력
- Validation 클래스를 통해 Error 검증
2. 당첨 번호 입력
- Validation 클래스를 통해 Error 검증
3. 서비스 번호 입력
- Validation 클래스를 통해 Error 검증

Validation
1. Lotto , LottoControler 예외 사항에 대한 검증
2. Input 예외 사항에 대한 검증

Output
1. Server Text를 출력

예외 처리 및 단위 테스트 구상

단위 테스트 목록
Lotto
LottoControler

예외 처리
1. Lotto , LottoControler
2. Input

예외시 재실행 방법
1. 반복문


추후 단위 테스트 구상 구체화 및 예외 처리 구체화 필요

----
2회차 
ErrorText 와 ServiceText는 따로 정할 필요 없음. -> 기능 제거

Enum 클래스를 활용해 로또 당첨 내역 산출하기
EnumMap을 이용해 로또 당첨 리스트를 구현한다.

각각 인터페이스를 이용하여 추상화하고 테스트 코드를 작성한다.

처음 모델링에 경우 각 클래스에 부담되는 책임이 너무 많아 이부분을 고려한다.
아키텍처 수준에서의 MVC 패턴을 채택한다.
또한 각 클래스별 책임을 괄호에 적었다.

Application(컨트롤러 생성)

LottoController
- view(input,output) 와 model 중계

view
- Input(동작에 필요한 입력)
- Output(결과를 나타내는 출력)
- ViewValidation(입력 값 검증)

model
- LottoMaker (로또 리스트 생성)
- Lotto(로또 정의)
- LottoValidation(로또 유효성 검증)
- LottoMakerValidation(로또 리스트 유효성 검증)
- LottoRank(로또 등수 산출)
- LottoResult(로또 리스트의 결과 산출)

리팩토링 과정에서  각각 입력에 대한 인터페이스를 정의하여
추상화 목표.

input 예외 리스트
1. 돈
- 1000원 단위인지 검증
- null인지 검증
- 문자가 들어왔는지 검증
2. 당첨 번호 및 서비스 번호 검증
- 수의 범위가 1~45까지인가?
- 중복 검증

model 예외 리스트
1. 로또
- 수의 범위가 1~45까지인가?
- null인지 검증
- 문자가 들어왔는지 검증
- 중복 검증
2. 로또 리스트
- 개수 검증(돈과 개수)

----
3회차

설계 수정사항

model 예외 리스트
생성 단계에서 숫자로 생성하니 컴파일 단에서 오류가 걸리짐.
문자 검증 필요없음.
로또 번호 사이즈가 6이라 null을 검증할 필요가 없음.

1. 로또
- 수의 범위가 1~45까지인가?
- 사이즈가 6인지 검증
- 중복 검증

LottoValidation 구현 완료. 추후 인터페이스로 추상화
----
4회차

LottoValidation 추상화
의존성 주입을 생성자에서 하고싶었는데 문제 조건으로
필드 구조를 바꾸면 안돼서 함수에서 직접 의존성을 주입했다.

LottoMaker 구현
- 로또 번호 생성
- 로또 번호를 바탕으로 로또 리스트 생성

makeLottoNumber를 테스트 하기위해 인터페이스로 생성하는 부분을
뺄 필요가 있다.
IMakeLottoNumber 인터페이스를 만들어 상속받고 추후 테스트하자.

또 lottoMaker 부분도 인터페이스화해서 controller가 인터페이스에 의존하도록
만들 수 도 있다.
----
5회차

당첨 번호와 대조하여 등수를 산출하는 기능을 추가하려고하는데
LottoRank는 열거형으로 등수의 특성을 정의하는것을 책임으로 두고싶어서
등수를 구하는데 필요한 정보를 구하는 class를 따로 추가해야함을 느꼈다.

model
- LottoMaker (로또 리스트 생성)
- Lotto(로또 정의)
- LottoValidation(로또 유효성 검증)
- LottoMakerValidation(로또 리스트 유효성 검증)
- LottoRank(로또 등수 정의)
- LottoCompare(당첨 번호와 로또간 개수 비교)
- LottoResult(로또 리스트의 결과 산출)

LottoCompare
생성된 로또 번호에서 보너스 번호 일치여부와 당첨 번호 일치 수를
출력한다.

해당 부분도 인터페이스를 이용해 추상화하는 것이 필요
----
6회차

수정 사항
1. validation 상수 선언
2. maker getLottos 추가

lottoRank 정의
1. 등수, 가격, 매치 수, 비교 람다식
2. getRank : static method를 사용해 어떠한 열거형에 해당하는지
객체를 반환함.
----
7회차

LottoResult 구현
EnumMap을 사용.
rank가 무엇인지에 따라 map에서 1을 더함.

LottoMaker와 LottoCompare을 통해
각 로또별 rank가 무엇인지 열거형에서 찾고
이를 map에 추가함.
----
8회차

수정사항
- 코딩 컨벤션 : 상수 소문자, 대문자로 변경
- input, output, viewvalidation 구현

input
- bonus, money, winning 입력

ouput
- 입력받을때 , 각각 결과에 대한 출력

viewvalidation
- money, bonus, lotto 에 대한 예외 발생
- interface로 추상화 완료

추후 컨트롤러 추가, 단위 테스트 코드 작성, 추상화,
예외 추가, type chage에 대한 책임을 가지는 추가 클래스
생성이 필요.
