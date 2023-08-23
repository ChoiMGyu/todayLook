window.addEventListener('load', function() {
  clearMessages();
  
  var formElem = document.querySelector('form');
  formElem.onsubmit = submitForm;

});

function clearMessages(){
  var messages = document.getElementsByClassName('alert-message');
  for(var i = 0; i < messages.length; i++){
     messages[i].style.display = 'none';
  }
}

/********showMessage 수정 (querySelector)(08.09)*******************************/
function showMessage(inputElement, message){
 var messageElem = inputElement.parentNode.querySelector('.alert-message');
 messageElem.style.display = 'inline';
 messageElem.innerText = message;

 inputElement.focus();
}
/******************************************************************************/


function submitForm() {
  //acount info
  var accountInput = document.querySelector('input[name="login_id"]');
  var passwordInput = document.querySelector('input[name="password"]');
  var passwordConfirmInput = document.querySelector('input[name="repassword"]');
  var nickNameInput = document.querySelector('input[name="nickname"]');

  //select, radio. checkbox
  var departmentInput = document.querySelector('select[name="department"]');
  var departmentSelectInput = document.querySelector('select[name="department_select"]');
  var telephoneInput = document.querySelector('select[name="memberPhone_sub"]');
  var telephone2Input = document.querySelector('input[name="memberPhone"]');
  var radioInput = document.querySelector('input[name="gender"]:checked');
  var checkInput = document.querySelector('input[name="agree"]');

  var emailIdInput = document.querySelector('#domain-txt');
  var emailDomainInput = document.querySelector('#domain-txt1');
  var emailDomainSelect = document.querySelector('#domain-list');

  console.log("아이디:", accountInput.value);
  console.log("비밀번호:", passwordInput.value);
  console.log("비밀번호 확인:", passwordConfirmInput.value);
  console.log("닉네임:", nickNameInput.value);
  console.log("대학 선택:", departmentInput.value);
  console.log("학과 선택:", departmentSelectInput.value);
  console.log("휴대전화 번호 앞자리:", telephoneInput.value);
  console.log("휴대전화 번호:", telephone2Input.value);
  console.log("성별:", radioInput.value);
  console.log("동의여부:", checkInput.checked);
  var emailDomain = emailDomainSelect.value === 'type' ? emailDomainInput.value : emailDomainSelect.value;
  var email = emailIdInput.value + '@' + emailDomain;
  console.log("이메일:", email);

  var success = true;
  if (accountInput.value.length < 6) {
    showMessage(accountInput, '아이디는 6자리 이상으로 설정해주세요.');
    success = false;
  }

  if (passwordInput.value.length < 8) {
    showMessage(passwordInput, '비밀번호는 8자리 이상이여야 합니다.');
    success = false;
  }

  if (passwordConfirmInput.value !== passwordInput.value) {
    showMessage(passwordConfirmInput, '비밀번호를 동일하게 입력해주세요.');
    success = false;
  }
  return success;
}


const domainInputEl = document.querySelector('#domain-txt1')
const domainListEl = document.querySelector('#domain-list')

// select 옵션 변경 시
domainListEl.addEventListener('change', (event) => {
  // option에 있는 도메인 선택 시
  if(event.target.value !== "type") {
    // 선택한 도메인을 input에 입력하고 disabled
    domainInputEl.value = event.target.value
    domainInputEl.disabled = true
  } else { // 직접 입력 시
    // input 내용 초기화 & 입력 가능하도록 변경
    domainInputEl.value = ""
    domainInputEl.disabled = false
  }
})

function changeDepartment() {
  // 첫 번째 select 요소의 값을 가져옵니다.
  var university = document.getElementById("university").value;
  
  // 두 번째 select 요소의 값을 초기화합니다.
  document.getElementById("department").innerHTML = "";
  
  // 대학 소속에 따라 다른 학과 종류를 보여줍니다.
  if (university === "문과대학") {
    // 대학1의 학과 종류를 추가합니다.
    var option1 = document.createElement("option");
    option1.text = "중국언어문화학과";
    document.getElementById("department").add(option1);
    
  } else if (university === "인문대학") {
    // 대학2의 학과 종류를 추가합니다.
    var option2 = document.createElement("option");
    option2.text = "국어국문학과";
    document.getElementById("department").add(option2);
    
    var option3 = document.createElement("option");
    option3.text = "일어일문학과";
    document.getElementById("department").add(option3);

    var option4 = document.createElement("option");
    option4.text = "영어영문학과";
    document.getElementById("department").add(option4);

    var option5 = document.createElement("option");
    option5.text = "유럽언어문화학부";
    document.getElementById("department").add(option5);

    var option6 = document.createElement("option");
    option6.text = "철학과";
    document.getElementById("department").add(option6);

    var option7 = document.createElement("option");
    option7.text = "역사학과";
    document.getElementById("department").add(option7);

    var option8 = document.createElement("option");
    option8.text = "문화인류학과";
    document.getElementById("department").add(option8);
  } else if (university === "자연과학대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option9 = document.createElement("option");
    option9.text = "수학과";
    document.getElementById("department").add(option9);
    
    var option10 = document.createElement("option");
    option10.text = "통계학과";
    document.getElementById("department").add(option10);

    var option11 = document.createElement("option");
    option11.text = "물리학과";
    document.getElementById("department").add(option11);

    var option12 = document.createElement("option");
    option12.text = "화학과";
    document.getElementById("department").add(option12);

    var option13 = document.createElement("option");
    option13.text = "생명과학과";
    document.getElementById("department").add(option13);
  } else if (university === "공과대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option14 = document.createElement("option");
    option14.text = "건설시스템공학과";
    document.getElementById("department").add(option14);
    
    var option15 = document.createElement("option");
    option15.text = "환경공학과";
    document.getElementById("department").add(option15);

    var option16 = document.createElement("option");
    option16.text = "도시공학과";
    document.getElementById("department").add(option16);

    var option17 = document.createElement("option");
    option17.text = "건축학과";
    document.getElementById("department").add(option17);

    var option18 = document.createElement("option");
    option18.text = "신소재공학과";
    document.getElementById("department").add(option18);

    var option19 = document.createElement("option");
    option19.text = "화학공학과";
    document.getElementById("department").add(option19);

    var option20= document.createElement("option");
    option20.text = "파이버시스템공학과";
    document.getElementById("department").add(option20);
  } else if (university === "기계IT대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option21= document.createElement("option");
    option21.text = "기계공학과";
    document.getElementById("department").add(option21);

    var option22= document.createElement("option");
    option22.text = "전기공학과";
    document.getElementById("department").add(option22);

    var option23= document.createElement("option");
    option23.text = "전자공학과";
    document.getElementById("department").add(option23);

    var option24= document.createElement("option");
    option24.text = "컴퓨터공학과";
    document.getElementById("department").add(option24);

    var option25= document.createElement("option");
    option25.text = "정보통신공학과";
    document.getElementById("department").add(option25);

    var option26= document.createElement("option");
    option26.text = "미래자동차공학과";
    document.getElementById("department").add(option26);

    var option27= document.createElement("option");
    option27.text = "로봇기계공학과";
    document.getElementById("department").add(option27);

    var option28= document.createElement("option");
    option28.text = "로봇공학과";
    document.getElementById("department").add(option28);

    var option29= document.createElement("option");
    option29.text = "파이버시스템공학과";
    document.getElementById("department").add(option29);
  } else if (university === "소프트웨어융합대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option30 = document.createElement("option");
    option30.text = "소프트웨어융합학부";
    document.getElementById("department").add(option30);
  }else if (university === "사회과학대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option31 = document.createElement("option");
    option31.text = "정치외교학과";
    document.getElementById("department").add(option31);

    var option32 = document.createElement("option");
    option32.text = "행정학과";
    document.getElementById("department").add(option32);

    var option33 = document.createElement("option");
    option33.text = "심리학과";
    document.getElementById("department").add(option33);

    var option34 = document.createElement("option");
    option34.text = "사회학과";
    document.getElementById("department").add(option34);

    var option35 = document.createElement("option");
    option35.text = "미디어커뮤니케이션학과";
    document.getElementById("department").add(option35);

    var option36 = document.createElement("option");
    option36.text = "경찰행정학과";
    document.getElementById("department").add(option36);

    var option37 = document.createElement("option");
    option37.text = "군사학과";
    document.getElementById("department").add(option37);

  }else if (university === "경영대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option38 = document.createElement("option");
    option38.text = "경제금융학부";
    document.getElementById("department").add(option38);

    var option39 = document.createElement("option");
    option39.text = "경영학과";
    document.getElementById("department").add(option39);

    var option40 = document.createElement("option");
    option40.text = "무역학과";
    document.getElementById("department").add(option40);

    var option41 = document.createElement("option");
    option41.text = "회계세무학과";
    document.getElementById("department").add(option41);

    var option42 = document.createElement("option");
    option42.text = "항공운송학과";
    document.getElementById("department").add(option42);

    var option43 = document.createElement("option");
    option43.text = "산업경영학과";
    document.getElementById("department").add(option43);

  }else if (university === "의과대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option44 = document.createElement("option");
    option44.text = "의예과";
    document.getElementById("department").add(option44);
  }else if (university === "약학대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option45 = document.createElement("option");
    option45.text = "약학부";
    document.getElementById("department").add(option45);
  }else if (university === "생명응용과학대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option46 = document.createElement("option");
    option46.text = "식품경제외식학과";
    document.getElementById("department").add(option46);

    var option47 = document.createElement("option");
    option47.text = "원예생명과학과";
    document.getElementById("department").add(option47);

    var option48 = document.createElement("option");
    option48.text = "식품공학과";
    document.getElementById("department").add(option48);

    var option49 = document.createElement("option");
    option49.text = "생명공학과";
    document.getElementById("department").add(option49);

    var option49 = document.createElement("option");
    option49.text = "의생명공학과";
    document.getElementById("department").add(option49);

    var option50 = document.createElement("option");
    option50.text = "조경학과";
    document.getElementById("department").add(option50);

    var option51 = document.createElement("option");
    option51.text = "산림자원학과";
    document.getElementById("department").add(option51);

  }else if (university === "생활과학대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option52 = document.createElement("option");
    option52.text = "가족주거학과";
    document.getElementById("department").add(option52);

    var option53 = document.createElement("option");
    option53.text = "주거환경학과";
    document.getElementById("department").add(option53);

    var option54 = document.createElement("option");
    option54.text = "식품영양학과";
    document.getElementById("department").add(option54);

    var option55 = document.createElement("option");
    option55.text = "체육학과";
    document.getElementById("department").add(option55);

    var option56 = document.createElement("option");
    option56.text = "의류패션학과";
    document.getElementById("department").add(option56);

    var option57 = document.createElement("option");
    option57.text = "휴먼서비스학과";
    document.getElementById("department").add(option57);
  }else if (university === "사범대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option58 = document.createElement("option");
    option58.text = "국어교육과";
    document.getElementById("department").add(option58);

    var option59 = document.createElement("option");
    option59.text = "영어교육과";
    document.getElementById("department").add(option59);

    var option60 = document.createElement("option");
    option60.text = "한문교육과";
    document.getElementById("department").add(option60);

    var option61 = document.createElement("option");
    option61.text = "수학교육과";
    document.getElementById("department").add(option61);

    var option62 = document.createElement("option");
    option62.text = "유아교육과";
    document.getElementById("department").add(option62);

    var option63 = document.createElement("option");
    option63.text = "특수체육교육과";
    document.getElementById("department").add(option63);
  }else if (university === "음악대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option64 = document.createElement("option");
    option64.text = "음악과";
    document.getElementById("department").add(option64);

    var option65 = document.createElement("option");
    option65.text = "성악과";
    document.getElementById("department").add(option65);

    var option66 = document.createElement("option");
    option66.text = "기악과";
    document.getElementById("department").add(option66);
  }else if (university === "예술대학") {
    // 대학3의 학과 종류를 추가합니다.
    var option67 = document.createElement("option");
    option67.text = "회화과";
    document.getElementById("department").add(option67);

    var option68 = document.createElement("option");
    option68.text = "트랜스아트과";
    document.getElementById("department").add(option68);

    var option69 = document.createElement("option");
    option69.text = "시각디자인학과";
    document.getElementById("department").add(option69);

    var option70 = document.createElement("option");
    option70.text = "산업디자인학과";
    document.getElementById("department").add(option70);

    var option71 = document.createElement("option");
    option71.text = "생활제품디자인학과";
    document.getElementById("department").add(option71);

    var option72 = document.createElement("option");
    option72.text = "음악학과";
    document.getElementById("department").add(option72);
  }else{
    // 대학3의 학과 종류를 추가합니다.
    var option73 = document.createElement("option");
    option73.text = "";
    document.getElementById("department").add(option73);
  }
}

/*******중복 기능 생성(08.10)***************************************************/




/******************************************************************************/