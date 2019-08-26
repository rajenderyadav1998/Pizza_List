package in.devco.pizzalist.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "menu")
public class Menu {
    @ElementList(inline = true)
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}