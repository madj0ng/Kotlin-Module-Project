interface MenuItem {
    override fun toString(): String
}

class Archive(private val name: String) : MenuItem {
    // Список заметок
    var notes: ArrayList<MenuItem> = arrayListOf()

    override fun toString(): String {
        return name
    }
}

class Note(private val name: String, private val noteText: String) : MenuItem {
    override fun toString(): String {
        return name
    }

    fun getText(): String {
        return noteText
    }
}

class Create(private val menuType: MenuType) : MenuItem {
    override fun toString(): String {
        return menuType.create
    }
}

class Exit(private val menuType: MenuType) : MenuItem {
    override fun toString(): String {
        return menuType.exit
    }
}