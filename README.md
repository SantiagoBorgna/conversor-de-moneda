# Conversor de Moneda 

Este es un conversor de moneda de consola, creado como parte del Desafío Back-End de Alura Latam y Oracle (ONE).

## Características
- Menú interactivo en la consola para una fácil navegación.
- Conexión en tiempo real a una API para obtener tasas de cambio precisas.
- Manejo de entradas de usuario y validación básica.
- Código estructurado que separa la lógica de la API de la lógica de la aplicación principal.

### Conversiones disponibles
- Dólar (USD) =>> Peso Argentino (ARS)
- Peso Argentino (ARS) =>> Dólar (USD)
- Dólar (USD) =>> Real Brasileño (BRL)
- Real Brasileño (BRL) =>> Dólar (USD)
- Dólar (USD) =>> Peso Colombiano (COP)
- Peso Colombiano (COP) =>> Dólar (USD)

### Tecnologías Utilizadas
- Java 11+
- Maven
- Java HttpClient
- GSON

## Cómo Empezar

Para ejecutar este proyecto en tu máquina local, segui estos pasos.

### Prerrequisitos
- Tener instalado el JDK 11 o una versión superior.
- Tener instalado Maven (o usar el wrapper de Maven que provee tu IDE).
- Una API Key gratuita de ExchangeRate-API.

### Instalación y Ejecución

- Clona el repositorio:

git clone [https://github.com/SantiagoBorgna/conversor-de-moneda.git](https://github.com/SantiagoBorgna/conversor-de-moneda.git)

- Abre el proyecto:
- Configura tu API Key:
  - Navega al archivo: src/main/java/com/conversor/api/ApiClient.java.
  - Busca la siguiente línea: private static final String API_KEY = "PON_TU_API_KEY_AQUI";
  - Reemplaza "PON_TU_API_KEY_AQUI" con la API Key que obtuviste de ExchangeRate-API.
- Ejecuta la aplicación:
  - Busca el archivo src/main/java/com/conversor/Main.java.
  - Haz clic derecho sobre él y selecciona "Run 'Main.main()'".
  - La aplicación se ejecutará en la consola de tu IDE.

## Autor

Santiago Borgna

https://www.linkedin.com/in/santiago-borgna/

https://github.com/SantiagoBorgna
