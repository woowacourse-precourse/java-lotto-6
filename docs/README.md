## 1. **돈 입력받기**
money(model) 생성
   
- [ ] inputView 로 string 입력 받기
- [ ] '숫자 생성기'가 숫자로 변환 
- [ ] 검증 : stringToInt, **'숫자 생성기'는 숫자에 관련한 검증만 수행**
- [ ] controller 에게 숫자를 넘겨 money model 생성
- [X] money 모델에게 생성자로 숫자를 넘겨 money 생성 
- [X] 검증 : money 모델은 비즈니스 로직만 검증 수행
  - [X] 로또 금액에 맞는 금액 ex) 1000으로 나누어 떨어짐
- [ ] outputView 에게 Money model 을 전달하여 결과 출력
***
## 2. **랜덤 로또들 생성하기**
lottos(model) 생성
   
- [ ] 숫자 생성기로 랜덤 숫자 리스트들을 담은 리스트 생성
- [ ] controller 에게 인자로 리스트들을 넘겨서 Lottos 모델 반환
- [ ] lottos 모델에게 리스트를 넘겨 lottos 생성
- [ ] lottos 모델은 lotto 모델에게 리스트 하나 넘겨서 Lotto 모델 생성
- [ ] outputView 에게 Lottos model 을 전달하여 결과 출력
***
## 3. **정답 로또 생성하기**
lotto(model) 생성
   
- [ ] inputView 로 string 입력받기
- [ ] '숫자 생성기' 로 숫자 리스트 하나 만들기
- [ ] 검증 : **'숫자 생성기'는 숫자에 관련한 검증만 수행**
  - [ ] stringToInt
  - [ ] parsing
- [ ] controller 에게 숫자 리스트 넘겨서 lotto model 하나 생성 및 반환
- [ ] 생성할 때 정렬 수행
- [ ] 검증 : lotto 모델은 비즈니스 로직만 검증 수행
  - [ ] 각 숫자가 1 ~ 45인지 범위 체크
  - [ ] 길이가 6인지 숫자 갯수 체크
***
## 4. **보너스 넘버 생성하기**
bonus(model) 생성
   
- [ ] inputView 로 string 입력 받기
- [ ] '숫자 생성기'가 숫자로 변환
- [ ] 검증 : stringToInt, **'숫자 생성기'는 숫자에 관련한 검증만 수행**
- [ ] controller 에게 숫자와 Lotto 를 넘겨 bonus model 생성
- [ ] bonus 모델에게 생성자로 숫자와 Lotto 를 넘겨 bonus model 생성
- [ ] 검증 : bonus 모델은 비즈니스 로직만 검증 수행
  - [ ] 숫자가 1 ~ 45인지 범위 체크
  - [ ] Lotto 와 중복되는 숫자가 있는지 체크
***
## 5. **당첨 내역 출력하기**
Result(model) 생성하기 ,
Rank(enum) 객체 활용

- [ ] controller 에게 Lotto, bonus, lottos 를 넘겨 result model 생성
- [ ] Result model 은 Map<Rank,Integer> 을 활용한 일급 컬렉션, key : 등수, value : 몇 개
- [ ] Lotto 끼리 비교를 통해 몇 개의 숫자가 겹치는 지 검증하여 Rank 반환
  - [ ] 5개가 겹친다면 bonus 까지 확인
- [ ] 총 수익 상금을 Money 로 전환해주는 비즈니스 로직
- [ ] outputView 에게 Result model 을 전달하여 결과 출력
***
## 5. **수익률 출력하기**
Rate(model) 생성하기
money(model) 객체 활용
  
- [ ] 구입 금액을 나타내는 Money 와 총 수익상금을 나타내는 money 를 통해 수익율 도출
- [ ] controller 에게 Money 객체 두 개를 넘겨 Rate model 생성
- [ ] BigDecimal을 활용해서 수익율 도출
- [ ] outputView 에게 Rate model 을 전달하여 결과 출력