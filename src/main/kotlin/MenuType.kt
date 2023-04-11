enum class MenuType(
    val create: String,
    val exit: String,
    val askName: String,
    val askText: String?,
    val insertSuccess: String
) {
    ARCHIVE(
        "Создать архив",
        "Выход",
        "Введите название архива",
        null,
        "Архив добавлен"
    ),
    NOTE(
        "Создать заметку",
        "Выход",
        "Введите название заметки",
        "Введите текст заметки",
        "Заметка добавлена"
    )
}