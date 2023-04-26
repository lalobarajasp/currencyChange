#Currency Exchange💰
- This application is responsible for generating the change of a currency.
- The necessary parameters to work are entered in the param of your HTTP request, example:
```http
http://localhost:8080/api/change/?baseCurrency=USD&targetCurrency=MXN&amount=1
```
- The currency type for baseCurrency is found in the package "reference" file "BaseCurrency".
- The currency type for targetCurrency is found in the package "reference" file "TargetCurrency".
- The amount is the value of the currency to be exchanged.

## How was it builded?
The application was developed in SpringBoot and used [Free Currency Conversion API](https://freecurrencyapi.com/)



