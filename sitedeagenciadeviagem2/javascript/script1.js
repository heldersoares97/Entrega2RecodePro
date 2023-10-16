function calcularPassagem() {
    const origem = document.getElementById("origem").value;
    const destinoElement = document.getElementById("destino");
    const destinoTexto = destinoElement.options[destinoElement.selectedIndex].text; // Obtém o texto da opção selecionada
    let precoPassagem = parseFloat(document.getElementById("preco").value);

    // Lógica para calcular o valor da passagem com base nos destinos e preços
    let valorTotal = 0;

    switch (destinoElement.value) {
        case "destino1":
            valorTotal = precoPassagem + 400;
            break;
        case "destino2":
            valorTotal = precoPassagem + 900;
            break;
        case "destino3":
            valorTotal = precoPassagem + 300;
            break;
        case "destino4":
            valorTotal = precoPassagem + 950;
            break;
        case "destino5":
            valorTotal = precoPassagem + 850;
            break;
        case "destino6":
            valorTotal = precoPassagem + 700;
            break;
        default:
            alert("Destino não reconhecido");
            break;
    }

    document.getElementById("resultado").innerHTML = `O valor total da passagem de ${origem} para ${destinoTexto} é R$ ${valorTotal.toFixed(2)}`;
}

