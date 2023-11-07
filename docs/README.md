
## 전체 기능 구현 체크리스트

- ✔️ 사용자에게 복권 구매 금액을 입력 받음 (View -> Input -> readPurchaseAmount())
- ✔️ 입력값 유효성 검증 (Controller -> readPurchaseAmount())
  - [x] while문을 활용해 올바른 값을 얻을때까지 반복
  - [x] 금액이 1000단위가 아니면 error throw
  - [x] 입력한 값이 숫자가 아니면 error throw
        
- ✔️ 구매 개수만큼 로또 생성 (Model -> LottoTicket -> generateLottoTickets())
  - [x] 주어진 Random 라이브러리와 Lotto 클래스를 사용
  - [x] Lotto 객체의 길이와 중복 체크 valid 추가

- ✔️ 로또 생성 결과 출력 (View -> Output -> printLotto())
        
- ✔️ 사용자에게 당첨 번호를 입력 받음 (View -> Input -> readWinningNumbers())
- ✔️ 입력값 유효성 검증 (Controller -> readWinningNumbers())
  - [x] while문을 활용해 올바른 값을 얻을때까지 반복
  - [x] 개수가 6개가 아니면 error throw
  - [x] 중복이 존재하면 error throw (Set 자료구조 활용)  
  - [x] 유효한 값이 아니면 error throw
  - [x] 에러 문구가 중복 출력되지 않게 트리거 사용 
        
- ✔️  사용자에게 보너스 번호를 입력 받음 (View -> Input -> readBonusNumber())
- ✔️ 입력값 유효성 검증 (Controller -> readBonusNumber())
  - [x] while문을 활용해 올바른 값을 얻을때까지 반복
  - [x] 입력한 값이 숫자가 아니면 error throw
        
- ✔️ 생성된 복권과 당첨/보너스 번호를 대조 (Model -> Result -> calculateResults())
- ✔️ 수익률 계산 (Model -> Result -> resultsToProfitRate())
- ✔️ 실행 결과와 수익률 출력 (View -> Output -> printResults())
- ✔️ 에러 문구 상수화 (View -> ErrorText)

- ✔️ 로또 생성에 대한 단위 테스트 추가 (LottoTicketTest)
- ✔️ 결과 계싼에 대한 단위 테스트 추가 (ResultTest)

<br />

## MVC 관점 분리

#### 1) Model (비즈니스 로직)
- LottoTicket : 인자로 받은 구매 금액에 따라 로또를 생성, List<Lotto>를 return
- Result : 생성된 로또 목록과 당첨번호, 보너스번호를 대조한 값을 Map<String, Integer> 형태 리턴
- 리턴한 result 값을 인자로 수익률을 계산해 double 형태로 리턴. 별도의 클래스로 분리하면 더 좋았을 것 같음

#### 2) View (입출력)
- Input: 사용자에게 금액, 당첨 번호, 보너스 번호를 입력받음
- Output: 로또 생성 결과, 계산 결과, 수익률을 출력함
- Error: 유효성 검사중 에러 발생시 에러 문구를 출력함

#### 3) Controller (게임 진행)
- View를 통해 사용자에게 구매금액을 입력받음
- 입력값의 유효성 검증은 Controller에서 처리
- 에러 발생시 View를 통해 출력
 
- Model의 Lottoticket을 활용해 로또 생성
- View를 통해 생성한 로또 값을 사용자에게 출력
 
- View를 통해 사용자에게 당첨 번호와 보너스 번호를 입력받음
- 유효성 검증은 Controller가 직접, 에러 출력은 View를 호출해 처리
  
- Model의 Result을 호출해 결과 대조 + 수익률 계산
- View를 통해 수익률 출력

<br />

## 커밋메세지 컨벤션
- feat = 새로운 기능 추가
- fix = 버그 수정
- refactor = 리팩토리
- style = css, ui, design 변경
- comment = 주석
- docs = 문서 수정
- test = 테스트 관련
- rename / remove = 파일 이름 변경 / 삭제

