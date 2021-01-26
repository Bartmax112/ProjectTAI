function dodaj() {


    if (document.getElementById('login') != null && document.getElementById('password') != null) {
        usun();
        var log = document.getElementById('login').value;
        var pass = document.getElementById('password').value;
        sessionStorage.setItem(log,pass);
    } else {
        alert("Wszystkie pola z gwiazdka musza być wypelnione");
    }
    pokaz();


}


function usun() {
    sessionStorage.clear();
}
