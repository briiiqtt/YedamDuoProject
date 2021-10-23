window.onload = function () {

    // << 입력창 클릭시 value = null;
    let inputs = document.getElementsByTagName('input')
    for (let i = 0; i < inputs.length; i++) {
        inputs[i].onclick = function(){
            inputs[i].setAttribute('value','');
        }
    }
    // >>
}