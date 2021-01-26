function dodaj() {
    var item = {};
    var re = new RegExp('[A-Z]{1}[a-z]{2,12} [A-Z]{1}[a-z]{2,18}');
    if (!re.test(document.getElementById('name').value)) {
        alert("Imie i nazwisko nie sa poprawne");
        return;
    }
    re = new RegExp('^[1-9][0-9]{15}$');
    if (!re.test(document.getElementById('cardNr').value)) {
        alert("Numer karty nie sa poprawny");
        return;
    }
    re = new RegExp('(1[0-9]|0[1-9])\/[0-9]{2}');
    if (!re.test(document.getElementById('expDate').value)) {
        alert("Numer ważności karty nie jest poprawny");
        return;
    }

    re = new RegExp('[0-9]{3}');
    if (!re.test(document.getElementById('cvv').value)) {
        alert("Kod CVV karty nie jest poprawny");
        return;
    }

    if (document.getElementById('name') != null && document.getElementById('cardNr') != null && document.getElementById('expDate') != null && (document.getElementById('Person') != null || document.getElementById('Company') != null) && document.getElementById('cvv') != null) {
        item.name = document.getElementById('name').value;
        item.cardNr = document.getElementById('cardNr').value;
        item.expDate = document.getElementById('expDate').value;
        
        
        if (document.getElementById('Person').checked) {
            item.subject = "Person";
        } else if (document.getElementById('Company').checked) {
            item.subject = "Company";
        }
        item.cvv = document.getElementById('cvv').value;
        var lista = JSON.parse(localStorage.getItem('lista'));
        if (lista === null) lista = [];
        lista.push(item);
        localStorage.setItem('lista', JSON.stringify(lista));
    } else {
        alert("Wszystkie pola z gwiazdka musza być wypelnione");
    }
    pokaz();


}


function pokaz() {
    var lista = JSON.parse(localStorage.getItem('lista'));
    var tresc = "";
    if (lista != null) {
        for (i = 0; i < lista.length; i++) {
            var tmp = lista[i];
            tresc += '<div class="entity">' +
                '<table>'+
                '<tr><td>Name and surname:<br />' + lista[i].name + '</td></tr>' +
                '<tr><td>Card number:<br />' + lista[i].cardNr + '</td></tr>' +
                '<tr><td>Expiration date:<br />' + lista[i].expDate + '</td></tr>' +
                '<tr><td>Subject:<br />' + lista[i].subject + '</td></tr>' +
                '<tr><td>CVV code:<br />' + lista[i].cvv + '</td></tr>' +
                '<tr><td>' + '<button onclick="edytuj(' + i + ')">Edit</button>'  + '<button onclick="usunJeden(' + i + ')">Delete</button>' + '</td></tr>' +
                '</table>'+
                "</div>";
        }
    }
    document.getElementById('blok').innerHTML = tresc;
}

function edytuj(n) {
    if (document.getElementById('name').value != "" && document.getElementById('cardNr').value != "" && document.getElementById('expDate').value != "" && document.getElementById('cvv').value != "") {
        var lista = JSON.parse(localStorage.getItem('lista'));
        var tmp = {};
        tmp.name = document.getElementById('name').value;
        tmp.cardNr = document.getElementById('cardNr').value;
        tmp.expDate = document.getElementById('expDate').value;
        tmp.cvv = document.getElementById('cvv').value;
        
        if (document.getElementById('Person').checked) {
            tmp.subject = "Person";
        } else if (document.getElementById('Company').checked) {
            tmp.subject = "Company";
        }

            if (lista === null) lista = [];
        lista[n] = tmp;
        localStorage.setItem('lista', JSON.stringify(lista));
    } else {
        alert("Wszystkie pola z gwiazdka musza być wypelnione");
    }
}

function usunJeden(n) {
    if(!confirm("Are you sure, you want to delete this card?"))return;
    var lista = JSON.parse(localStorage.getItem('lista'));
    lista.splice(n, 1);

    localStorage.setItem('lista', JSON.stringify(lista));
    pokaz();
}

function usun() {
    if(!confirm("Are you sure, you want to delete ALL cards?"))return;
    document.getElementById('blok').innerHTML = "";
    localStorage.clear();
}
