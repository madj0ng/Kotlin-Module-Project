class MenuRender {

    // Формирование элементов меню
    fun <T : MenuItem> renderMenu(
        type: MenuType,
        elements: List<T>
    ): LinkedHashMap<Int, MenuItem> {
        // Список элементов меню
        val menuList: LinkedHashMap<Int, MenuItem> = linkedMapOf()
        var i = 0

        menuList[i] = Create(type)
        for (element in elements) {
            i++
            menuList[i] = element
        }
        i++
        menuList[i] = Exit(type)

        return menuList
    }

    // Вывод меню в консоль
    fun printMenu(menuList: LinkedHashMap<Int, MenuItem>) {
        for (menu in menuList) {
            println("${menu.key}. ${menu.value}")
        }
    }
}