/*08.15 로그인 버튼 눌렀을시 submitForm()실행, 아이디 비밀번호 데이터 전달해주는 기능 추가*/

window.addEventListener('load', function() {
    var formElem = document.querySelector('form');
    formElem.onsubmit = submitForm;
  
});

function submitForm() {
    //acount info
    var accountInput = document.querySelector('input[name="login_id"]');
    var passwordInput = document.querySelector('input[name="password"]');
  
    console.log("아이디:", accountInput.value);
    console.log("비밀번호:", passwordInput.value);
    
    var success = True;
    return success;
}

/*****************************************************************************************/