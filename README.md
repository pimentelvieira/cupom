# cupom

Importar Projeto como Maven
Projeto Spring Boot, basta rodar a classe Application.java que o server irá subir juntamente com o banco de dados H2 embedded
Subir o Apache MQ e criar uma fila chamada "cupom"

Endpoints:

/cupons/publica -> publica um cupom na fila
/cupons -> lê o cupom disponível na fila e gera o PDF com base nas informações cadastradas na base de dados
