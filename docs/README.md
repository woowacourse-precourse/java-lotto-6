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

ErrorText
1. Enum class로 정의
- errorCode 및 errorText

ServiceText
1. Enum class로 정의
- serviceCode 및 serviceText

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