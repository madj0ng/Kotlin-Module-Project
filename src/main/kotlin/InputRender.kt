import java.util.Scanner

class InputRender {
    private val scanner: Scanner = Scanner(System.`in`)

    fun renderInputMenu(menuList: LinkedHashMap<Int, MenuItem>): MenuItem? {
        // Проверка ввода цифры
        val line: Int?
        try {
            line = scanner.nextLine().toInt()
        } catch (ex: NumberFormatException) {
            println("Нужно ввести цифру")
            return null
        }

        // Проверка наличия пункта меню
        val menuItem: MenuItem? = menuList[line]
        if (menuItem == null) {
            println("Меню с такой цифрой отсутствует")
        }
        return menuItem
    }

    fun renderInputNotNullStr(): String {
        // Строка с удаленными конечными пробелами
        return scanner.nextLine().toString()
    }
}