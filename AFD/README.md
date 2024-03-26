# Autômato Finito Determinístico ⚪➖🔘

## Definição Formal

Um Autômato Finito Determinístico A é uma **5-tuple (ou quíntupla), (Q, Σ, δ, q0, F)** consistindo de:

- um conjunto finito de símbolos de entrada chamado Alfabeto (Σ)
- um conjunto finito de estados (Q)
- uma função de transição (δ : Q × Σ → Q)
- um estado inicial (q0 ∈ Q) e
- um conjunto de estados de aceitação (F ⊆ Q)

Seja w = a1a2 ... an uma cadeia de símbolos sobre o alfabeto Σ, O autômato M aceita a cadeia w se somente se existe uma sequência de estados, r0,r1, ..., rn, em Q com as seguintes condições:

- r0 = q0
- ri+1 = δ(ri, ai+1), para i = 0, ..., n−1
- rn ∈ F.

*fonte: Wikipédia.*

****
## Entendendo o código⚙️
 O código foi dividido em três arquivos:

 - **App.java**: arquivo responsável por obter os dados do usuário via terminal, além disso, também é o arquivo que instanciará o Autômato e imprimirá na tela as validações.
 - **Automato.java:** é o arquivo que possui a classe Autômato, é nela onde criei todas as características de um autômato (estados, alfabeto, funções de transição, etc).
 - **Chave.java:** é uma classe que, na verdade, representa uma **tupla** que será utilizada em conjunto com a estrutura de dados Map para realizar as funções de transição.

### App.java

De início, há simplesmente algumas perguntas realizadas ao usuário que correspondem aos elementos da quíntupla do Autômato Finito Determinístico, exceto as funções de transição. Isso ocorre porque, antes do recebimento das funções de transição, as variáveis: *estados, alfabeto, estadosFinais e o estadoInicial* serão os parâmetros para a instanciação do AFD.


<img src="https://i.ibb.co/zZq420P/Captura-de-tela-2024-03-26-001613.png">


Aqui está a instanciação de um AFD logo após o recolhimento dos dados necessários para a sua criação via terminal (System.in).

<img src="https://i.ibb.co/SmqW2vh/Captura-de-tela-2024-03-26-002052.png">

Após a sua instanciação, é chamado o método da classe: *receberFuncoesTransicao* que vai requisitar ao usuário que digite as funções de transição desse AFD, como parâmetro está sendo passado o único scanner do programa, para que ele possa coletar os dados dentro do escopo do método.

<img src="https://i.ibb.co/c2NX3dp/Captura-de-tela-2024-03-26-002337.png">


Como parte final do arquivo App.java, há apenas um loop while que serve para o usuário testar inúmeras palavras de sua vontade até que a palavra 'exit' seja digitada para finalizar o programa. É aqui que será chamado um método do AFD instanciado que é responsável por verificar se a palavra é aceita ou não.

<img src="https://i.ibb.co/yVMQDsP/Captura-de-tela-2024-03-26-002515.png">

### Automato.java

É o arquivo que contém a parte lógica do programa e todo o funcionamento de um AFD. Foi criada uma classe com atributos que são indispensáveis para a criação desse AFD, são eles:

- *Set<String> estados:* é o conjunto de estados do autômato, é do tipo (em java, da classe) String.
- *Set<String> alfabeto:* é o alfabeto do autômato, é do tipo (em java, da classe) String.
- *final String estadoInicial:* é o estado inicial do autômato, uma vez instanciado e informado pelo usuário o seu valor é imutável.
- *Set<String> estadosFinais:* é o conjunto de estados finais do autômato, é do tipo (em java, da classe) String.
- *Map<Chave<String,String>, String> funcoesTransicao:* é um Map do Java, ou seja, ele é uma estrutura do tipo Chave-Valor que tem como chave uma Tupla de Strings e um valor de String.

O construtor do autômato AFD instancia todas as estruturas de dados dos atributos para seguir as boas práticas do Java, além disso, é dentro do construtor que os outros atributos serão preenchidos com os próprios **metodos da classe, repare que esses são todos private para uso exclusivo da classe**.

<img src="https://i.ibb.co/gVy0ddK/Captura-de-tela-2024-03-26-003929.png">

<img src="https://i.ibb.co/tCS3Ypr/Captura-de-tela-2024-03-26-004027.png">

Logo em seguida, há os gets da Classe que foram úteis apenas para fins de depuração, principalmente no que se diz respeito ao Map onde foi preciso utilizar estruturas aninhadas.

<img src="https://i.ibb.co/7RTkyNJ/Captura-de-tela-2024-03-26-004134.png">

Agora, há os métodos criados para tratamento das entradas digitadas pelo usuário, visto que, quando o usuário insere os estados, o alfabeto, etc, todos esses atributos estão em uma só String, logo foi necessário realizar um split para colocar cada estado e símbolo em seu devido conjunto.

<img src="https://i.ibb.co/tcVt4K1/Captura-de-tela-2024-03-26-004339.png">

<img src="https://i.ibb.co/YfcnKm0/Captura-de-tela-2024-03-26-004602.png">

<img src="https://i.ibb.co/F6bbLDY/Captura-de-tela-2024-03-26-004610.png">



## Projeto Java 📁

O ambiente do projeto está configurado no modo padrão do VS Code:

- `src`: é a pasta que possui os arquivos de código;
- `lib`: é a pasta que tem as dependências do projeto.

Ademais, os arquivos compilados serão gerados por padrão na pasta *bin*

