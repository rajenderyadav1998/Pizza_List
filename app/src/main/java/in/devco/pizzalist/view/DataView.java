package in.devco.pizzalist.view;

import java.util.List;

import in.devco.pizzalist.model.Item;

public interface DataView {
    void loadData(List<Item> items);
    void loadFailed();
}
