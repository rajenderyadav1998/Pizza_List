package in.devco.pizzalist.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item")
public class Item {
    @Element(name = "id")
    private int id;

    @Element(name = "cost")
    private int cost;

    @Element(name = "name")
    private String name;

    @Element(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
