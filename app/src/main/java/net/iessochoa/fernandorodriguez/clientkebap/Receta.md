# Pasos a seguir para hacer el UIState

creamos un ClienteKebapUIState

```
data class ClienteKebapUiState (
val orders: List<KebapOrder> = emptyList()
){

}
```

Hay que inicializar los campos de la clase 