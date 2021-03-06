package ru.senina.itmo.lab6.commands;

import ru.senina.itmo.lab6.CollectionKeeper;
import ru.senina.itmo.lab6.labwork.LabWork;

/**
 * Command removes all elements greater than given
 */
@CommandAnnotation(name = "remove_greater", element = true, collectionKeeper = true)
public class RemoveGreaterCommand extends CommandWithoutArgs{
    private CollectionKeeper collectionKeeper;
    private LabWork element;

    public RemoveGreaterCommand() {
        super("remove_greater {element}", "remove all items from the collection that are greater than the specified one");
    }

    public void setCollectionKeeper(CollectionKeeper collectionKeeper){
        this.collectionKeeper = collectionKeeper;
    }

    @Override
    protected String doRun() {
        return collectionKeeper.removeGreater(element);
    }

    public LabWork getElement() {
        return element;
    }

    @Override
    public void setElement(LabWork element) {
        this.element = element;
    }
}
