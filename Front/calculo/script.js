// Função para registrar um novo usuário
function registrarUsuario() {
    const nome = document.getElementById("nome").value;
    const login = document.getElementById("login").value;
    const plvPass = document.getElementById("plvPass").value;
    const confirmPass = document.getElementById("confirm-plvPass").value;

    // Verifique se as senhas coincidem antes de prosseguir
    if (plvPass !== confirmPass) {
        alert("As senhas não coincidem. Por favor, tente novamente.");
        return;
    }

    const data = {
        nome,
        login,
        plvPass,
        role: "ADMIN"
    };

    fetch('http://25.6.206.68:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        console.log('Registro bem-sucedido:', result);

        // Após o registro bem-sucedido, você pode redirecionar o usuário para a página de login
        window.location.href = 'login.html';
    })
    .catch(error => {
        console.error('Erro no registro:', error);
    });
}

// Função para efetuar login
function fazerLogin() {
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // Aqui, você deve fazer uma solicitação para o servidor no IP 25.6.206.68:8080
    // para autenticar o usuário e a senha. Isso pode ser feito com AJAX ou fetch.

    // Exemplo de solicitação usando fetch (substitua isso pela implementação real):
    fetch('http://25.6.206.68:8080/auth/login', {
        method: 'POST',
        body: JSON.stringify({ username, password }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => response.json())
    .then(data => {
        if (data.authenticated) {
            // Login bem-sucedido, redirecionar para a página de boas-vindas
            window.location.href = 'bemvindo.html';
        } else {
            document.getElementById('mensagemErro').style.display = 'block';
        }
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}
