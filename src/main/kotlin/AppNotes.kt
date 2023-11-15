class AppNotes {

    // Старт программы
    fun run() {
        // Класс формирвания меню
        val menuRender = MenuRender()
        // Класс обработки ввода
        val inputRender = InputRender()
        // Список архивов
        val archives: ArrayList<MenuItem> = arrayListOf()

        println("Консольное приложение \"Заметки\"")
        // Формирование меню
        buildMenu(MenuType.ARCHIVE, archives, menuRender, inputRender)
    }

    // Окно списка меню
    private fun buildMenu(
        type: MenuType,
        itemList: ArrayList<MenuItem>,
        menuRender: MenuRender,
        inputRender: InputRender
    ) {
        while (true) {
            // Формирование списка меню
            val menuList = menuRender.renderMenu(type, itemList)

            // Вывод меню
            menuRender.printMenu(menuList)

            // Проверка ввода комманд
            val menuItem = inputRender.renderInputMenu(menuList)
            if (menuItem != null) {
                when (menuItem) {

                    // Формирование списка меню заметок
                    is Archive -> buildMenu(
                        MenuType.NOTE,
                        menuItem.notes,
                        menuRender,
                        inputRender
                    )

                    // Создание элемента меню
                    is Create -> createItem(
                        type,
                        itemList,
                        inputRender
                    )

                    // Просмотр заметки
                    is Note -> viewItem(menuItem)

                    // Выход
                    is Exit -> break
                }
            }
        }
    }

    // Окно создания элемента
    private fun createItem(
        type: MenuType,
        itemList: ArrayList<MenuItem>,
        inputRender: InputRender
    ) {
        // Получение наименования
        val name = this.getStr(type.askName, inputRender).trim()
        if (checkStrIsEmpty(name)) {
            println("Нужно ввести не пустое имя")
            return
        }

        val menuItem: MenuItem = when (type) {
            MenuType.ARCHIVE -> Archive(name)
            MenuType.NOTE -> {
                // Получние текста
                val text = getStr(type.askText!!, inputRender)
                if (checkStrIsEmpty(text)) {
                    println("Нужно ввести не пустую заметку")
                    return
                }
                Note(name, text)
            }
        }

        itemList.add(menuItem)
        println(type.insertSuccess)
    }

    // Окно просмотра заметки
    private fun viewItem(item: Note) {
        println("Текст заметки \"$item\":")
        println(item.getText())
    }

    private fun getStr(
        askStr: String,
        input: InputRender
    ): String {
        // Запрос на ввод
        println(askStr)

        // Результат ввода
        return input.renderInputNotNullStr()
    }

    private fun checkStrIsEmpty(str: String): Boolean {
        return str.replace(" ", "").isEmpty()
    }
}
